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
                        Question(question="What is 1 + 1?", answer="2", options=listOf("1", "3", "4")),
                        Question(question="What is 2 + 2?", answer="4", options=listOf("3", "5", "6")),
                        Question(question="What is 3 + 3?", answer="6", options=listOf("5", "7", "8")),
                        Question(question="What is 4 + 4?", answer="8", options=listOf("7", "9", "10")),
                        Question(question="What is 5 + 5?", answer="10", options=listOf("9", "11", "12"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.MATH,
                        category = "Arithmetic",
                        title = "Signed Numbers"
                    ),
                    listOf(
                        Question(question="What is 1 + -1?", answer="0", options=listOf("1", "3", "4")),
                        Question(question="What is 2 - 5?", answer="-3", options=listOf("1", "3", "4")),
                        Question(question="What is -3 + 3?", answer="0", options=listOf("1", "3", "4")),
                        Question(question="What is -4 + 4?", answer="0", options=listOf("1", "3", "4")),
                        Question(question="What is -5 + -5?", answer="-10", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.MATH,
                        category = "Arithmetic",
                        title = "Decimals"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.MATH,
                        category = "Algebra",
                        title = "Monomials"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.MATH,
                        category = "Algebra",
                        title = "Polynomials"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.MATH,
                        category = "Trigonometry",
                        title = "Trigonometric Functions"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.MATH,
                        category = "Trigonometry",
                        title = "Vectors"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
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
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.SCIENCE,
                        category = "Biology",
                        title = "Cells"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.SCIENCE,
                        category = "Biology",
                        title = "Photosynthesis"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.SCIENCE,
                        category = "Astronomy",
                        title = "Solar System"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.SCIENCE,
                        category = "Astronomy",
                        title = "Stars"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.SCIENCE,
                        category = "Physics",
                        title = "Kinematics"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.SCIENCE,
                        category = "Physics",
                        title = "Work and Energy"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
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
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.LANGUAGE,
                        category = "English",
                        title = "Nouns"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                /**
                 * APTITUDE TOPICS
                 */
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.APTITUDE,
                        category = "Text and Numbers",
                        title = "Sequence"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                ),
                TopicWithQuestion(
                    Topic(
                        subject = Subjects.APTITUDE,
                        category = "Visual",
                        title = "Patterns"
                    ),
                    listOf(
                        Question(question="What is 1.1 + 1?", answer="2.1", options=listOf("1", "3", "4")),
                        Question(question="What is 2.5 + 2?", answer="4.5", options=listOf("1", "3", "4")),
                        Question(question="What is 3 + 3.3?", answer="6.3", options=listOf("1", "3", "4")),
                        Question(question="What is 4 + 4.4?", answer="8.4", options=listOf("1", "3", "4")),
                        Question(question="What is 5 + 5.4?", answer="10.4", options=listOf("1", "3", "4"))
                    )
                )
            )

            return topicsWithQuestions;
        }
    }
}