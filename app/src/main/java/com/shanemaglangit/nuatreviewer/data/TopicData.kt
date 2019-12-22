package com.shanemaglangit.nuatreviewer.data

import com.shanemaglangit.nuatreviewer.util.Subjects

class TopicData {
    companion object {
        fun populateData(): List<TopicWithQuestion> {
            val topicsWithQuestions = listOf(
                /**
                 * MATH TOPICS
                 */
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.MATH,
                        category = "Arithmetic",
                        title = "Operations"
                    ),
                    listOf(
                        Question(question="What is 1 + 1?", answer="2"),
                        Question(question="What is 2 + 2?", answer="4"),
                        Question(question="What is 3 + 3?", answer="6"),
                        Question(question="What is 4 + 4?", answer="8"),
                        Question(question="What is 5 + 5?", answer="10")
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.MATH,
                        category = "Arithmetic",
                        title = "Negative Numbers"
                    ),
                    listOf(
                        Question(question="What is 1 + -1?", answer="0"),
                        Question(question="What is 2 - 5?", answer="-3"),
                        Question(question="What is -3 + 3?", answer="0"),
                        Question(question="What is -4 + 4?", answer="0"),
                        Question(question="What is -5 + -5?", answer="-10")
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.MATH,
                        category = "Arithmetic",
                        title = "Decimals"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1"),
                        Question(question="What is 2.5 + 2?", answer="4.5"),
                        Question(question="What is 3 + 3.3?", answer="6.3"),
                        Question(question="What is 4 + 4.4?", answer="8.4"),
                        Question(question="What is 5 + 5.4?", answer="10.4")
                    )
                ),
                /**
                 * SCIENCE TOPICS
                 */
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.SCIENCE,
                        category = "Chemistry",
                        title = "Periodic Elements"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1"),
                        Question(question="What is 2.5 + 2?", answer="4.5"),
                        Question(question="What is 3 + 3.3?", answer="6.3"),
                        Question(question="What is 4 + 4.4?", answer="8.4"),
                        Question(question="What is 5 + 5.4?", answer="10.4")
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.SCIENCE,
                        category = "Biology",
                        title = "Cells"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1"),
                        Question(question="What is 2.5 + 2?", answer="4.5"),
                        Question(question="What is 3 + 3.3?", answer="6.3"),
                        Question(question="What is 4 + 4.4?", answer="8.4"),
                        Question(question="What is 5 + 5.4?", answer="10.4")
                    )
                ),
                /**
                 * LANGUAGE TOPICS
                 */
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.LANGUAGE,
                        category = "Filipino",
                        title = "Panaguri"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1"),
                        Question(question="What is 2.5 + 2?", answer="4.5"),
                        Question(question="What is 3 + 3.3?", answer="6.3"),
                        Question(question="What is 4 + 4.4?", answer="8.4"),
                        Question(question="What is 5 + 5.4?", answer="10.4")
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.LANGUAGE,
                        category = "English",
                        title = "Nouns"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1"),
                        Question(question="What is 2.5 + 2?", answer="4.5"),
                        Question(question="What is 3 + 3.3?", answer="6.3"),
                        Question(question="What is 4 + 4.4?", answer="8.4"),
                        Question(question="What is 5 + 5.4?", answer="10.4")
                    )
                )
                /**
                 * APTITUDE TOPICS
                 */
            )

            return topicsWithQuestions;
        }
    }
}