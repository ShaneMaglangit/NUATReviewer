package com.shanemaglangit.nuatreviewer.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shanemaglangit.nuatreviewer.data.Topic
import com.shanemaglangit.nuatreviewer.databinding.TopicListItemBinding

class TopicAdapter(val topicListener: TopicListener) :
    ListAdapter<Topic, TopicAdapter.ViewHolder>(TopicDiffCallback()) {

    public override fun getItem(position: Int): Topic {
        return super.getItem(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, topicListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: TopicListItemBinding) :
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

class TopicListener(val clickListener: (topicId: Long) -> Unit) {
    fun onClick(topic: Topic) = clickListener(topic.topicId)
}

class TopicDiffCallback : DiffUtil.ItemCallback<Topic>() {

    override fun areItemsTheSame(oldItem: Topic, newItem: Topic): Boolean {
        return oldItem.topicId == newItem.topicId
    }

    override fun areContentsTheSame(oldItem: Topic, newItem: Topic): Boolean {
        return oldItem == newItem
    }
}