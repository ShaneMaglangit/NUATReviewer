package com.shanemaglangit.nuatreviewer.util

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.data.Topic
import com.shanemaglangit.nuatreviewer.databinding.TopicListItemBinding

private val ITEM_VIEW_TYPE_HEADER = 0
private val ITEM_VIEW_TYPE_ITEM = 1

class TopicAdapter(private val topicListener: TopicListener) : ListAdapter<DataItem, RecyclerView.ViewHolder>(TopicDiffCallback()) {

    public override fun getItem(position: Int): DataItem {
        return super.getItem(position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val item = getItem(position) as DataItem.TopicItem
                holder.bind(item.topic, topicListener)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ITEM_VIEW_TYPE_HEADER -> HeaderViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> ViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType ${viewType}")
        }
    }

    fun addHeaderAndSubmitList(list: List<Topic>?) {
        val items = when (list) {
            null -> listOf(DataItem.Header)
            else -> listOf(DataItem.Header) + list.map { DataItem.TopicItem(it) }
        }
        submitList(items)
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.TopicItem -> ITEM_VIEW_TYPE_ITEM
        }
    }

    class HeaderViewHolder(view: View): RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): HeaderViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.topic_header, parent, false)
                return HeaderViewHolder(view)
            }
        }
    }

    class ViewHolder private constructor(private val binding: TopicListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Topic, topicListener: TopicListener) {
            binding.topic = item
            binding.clickListener = topicListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TopicListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class TopicDiffCallback : DiffUtil.ItemCallback<DataItem>() {

    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}

class TopicListener(val clickListener: (topic: Topic) -> Unit) {
    fun onClick(topic: Topic) = clickListener(topic)
}

sealed class DataItem {
    abstract val id: String

    data class TopicItem(val topic: Topic) : DataItem() {
        override val id = topic.topicId
    }

    object Header : DataItem() {
        override val id = ""
    }
}