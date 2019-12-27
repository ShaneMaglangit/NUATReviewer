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
                        title = "Operations",
                        description = "The most fundamental branch of math is arithmetic operations. It consists of adding, subtracting, multiplying, and dividing numbers."
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
                        title = "Signed Numbers",
                        description = "The signed numbers consist of the positive numbers and their opposites or additive inverses, which are the negative numbers. Negative numbers are less than zero. Every number on the number line except zero has an opposite or additive inverse."
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
                        title = "Decimals",
                        description = "A decimal number can be defined as a number whose whole number part and the fractional part is separated by a decimal point. The dot in a decimal number is called a decimal point. The digits following the decimal point show a value smaller than one."
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
                        title = "Monomials",
                        description = "A monomial is an expression in algebra that contains one term, like 3xy. Monomials include: numbers, whole numbers and variables that are multiplied together, and variables that are multiplied together."
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
                        title = "Polynomials",
                        description = "Polynomials are algebraic expressions that include real numbers and variables. Division and square roots cannot be involved in the variables. The variables can only include addition, subtraction and multiplication. Polynomials contain more than one term. These are the sums of monomials."
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
                        title = "Trigonometric Functions",
                        description = "Trigonometric functions are elementary functions, the argument of which is an angle. Trigonometric functions describe the relation between the sides and angles of a right triangle. Applications of trigonometric functions are extremely diverse. "
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
                        category = "Geometry",
                        title = "Circle",
                        description = "A circle is all points in the same plane that lie at an equal distance from a center point. The circle is only composed of the points on the border. You could think of a circle as a hula hoop. It's only the points on the border that are the circle. The points within the hula hoop are not part of the circle and are called interior points."
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
                        title = "Periodic Table of Elements",
                        description = "The periodic table, also known as the periodic table of elements, is a tabular display of the chemical elements, which are arranged by atomic number, electron configuration, and recurring chemical properties. The structure of the table shows periodic trends."
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
                        title = "Introduction to Cells",
                        description = "All living things are made from one or more cells. A cell is the simplest unit of life and they are responsible for keeping an organism alive and functioning. This introduction to cells is the starting point for the area of biology that studies the various types of cells and how they work."
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
                        title = "Photosynthesis",
                        description = "Photosynthesis, the process by which green plants and certain other organisms transform light energy into chemical energy. During photosynthesis in green plants, light energy is captured and used to convert water, carbon dioxide, and minerals into oxygen and energy-rich organic compounds."
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
                        title = "Solar System",
                        description = "Our solar system consists of our star, the Sun, and everything bound to it by gravity — the planets Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus and Neptune, dwarf planets such as Pluto, dozens of moons and millions of asteroids, comets and meteoroids."
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
                        title = "Stars",
                        description = "Stars are giant, luminous spheres of plasma. There are billions of them — including our own sun — in the Milky Way Galaxy. And there are billions of galaxies in the universe."
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
                        title = "Kinematics",
                        description = "Kinematics is the branch of classical mechanics that describes the motion of points, objects and systems of groups of objects, without reference to the causes of motion (i.e., forces ). The study of kinematics is often referred to as the “geometry of motion.” Objects are in motion all around us."
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
                        title = "Work and Energy",
                        description = "The principle of work and kinetic energy (also known as the work–energy principle) states that the work done by all forces acting on a particle (the work of the resultant force) equals the change in the kinetic energy of the particle."
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
                        title = "Pangungusap",
                        description = "Ang Pangungusap ay ang kalipunan ng mga salitang nagsasaad ng isang buong diwa. Ito ay may patapos na himig sa dulo na nagsasaad ng diwa o kaisipang nais niyang ipaabot. Ito ay tinatawag na Sentence sa wikang Ingles."
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
                        title = "Nouns",
                        description = "A noun is a kind of word (see part of speech) that is usually the name of something such as a person, place, thing, quality, or idea. In English, nouns can be singular or plural. Nouns often need a word called an article or determiner (like the or that)."
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
                        title = "Sequence",
                        description = "In mathematics, a sequence is an enumerated collection of objects in which repetitions are allowed. Like a set, it contains members (also called elements, or terms). The number of elements (possibly infinite) is called the length of the sequence."
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
                        title = "Odd one out",
                        description = "Odd One Out assesses deductive reasoning, which is the core cognitive ability to apply rules to information in order to arrive at a logical conclusion. Odd One Out requires reasoning about the features of several shapes to deduce the one shape that does not fit in with the rest."
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

            return topicsWithQuestions
        }
    }
}