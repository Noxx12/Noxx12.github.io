---
layout: default
avatar: true
permalink: /
---
# **Professional Assessment**
	
The completion of my coursework in the Computer Science program and the creation of this ePortfolio have been transformative experiences that have influenced my professional aspirations and equipped me with the necessary skills to enter the competitive field of computer science. This ePortfolio is intended to demonstrate my technical proficiency, problem-solving abilities, and capacity to provide scalable, well-organized solutions. I have refined the skills required to make a meaningful contribution to any team or project by engaging in a combination of coursework, collaboration, and hands-on projects.

I was presented with a variety of opportunities to demonstrate my capabilities and develop professionally throughout the program. For instance, my capacity to devise object-oriented, modular solutions to real-world issues was underscored by the development of a Bank Simulator Program as part of a software development course. In the same vein, a team project on database design enabled me to work with my peers to develop a complex query-supporting, highly efficient, and normalized database, demonstrating my technical proficiency and ability to function effectively in a team setting.
	
Additionally, this journey served to confirm my professional principles: I prioritize security, collaboration, and the production of clean, maintainable code in order to achieve optimal outcomes. Through coursework and practical applications, these principles have been deeply ingrained in me, equipping me for positions that prioritize communication, adaptability, and problem-solving.

The program's emphasis on straightforward communication and the division of responsibilities was a lesson I learned from working within teams. For example, I served as the main developer for a capstone project, which involved the coordination of tasks, the resolution of conflicts, and the guarantee that all stakeholders' needs were satisfied. These experiences have further solidified my capacity to excel in collaborative environments.

My initiatives were contingent upon effective communication. I have honed my ability to cater my communication to the audience, ensuring alignment and clarity, whether I am presenting a software design to peers or explaining technical challenges to non-technical stakeholders. Our coursework concentrated on the optimization of efficacy by employing data structures like binary trees and hash tables, as well as algorithms like quicksort. One of the most notable accomplishments was the development of a pathfinding algorithm for a maze-solving AI. I successfully employed Dijkstra's algorithm to efficiently navigate intricate mazes.
	
I have experience in the design of scalable applications and the management of relational databases. For example, during a database administration course, I developed a fully normalized schema that facilitated optimized querying for a Contact system. End-to-end robustness in projects is guaranteed by my capacity to integrate backend functionality with software design principles. Security has been a consistent priority, particularly in a information security course where I implemented secure authentication systems and acquired the ability to identify vulnerabilities in software architecture. This knowledge has influenced my "security-first" perspective, which guarantees the privacy and integrity of my work.


---


*Course Outcomes*

In my ePortfolio, I demonstrate a portion of my skills and knowledge in my artifacts and narratives, which include the following outcomes:

i. Implement strategies to establish collaborative environments that permit disparate audiences to contribute to the decision-making process of organizations in the field of computer science. Develop, produce, and distribute professional-grade oral, written, and visual communications that are technically sound, coherent, and appropriately tailored to specific audiences and contexts.

ii.  Manage the trade-offs involved in design choices while designing and evaluating computing solutions that solve a given problem using algorithmic principles and computer science practices and standards that are appropriate to its solution.

iii. Demonstrate the capacity to employ well-founded and innovative techniques, skills, and tools in computing practices to implement computer solutions that deliver value and achieve industry-specific objectives.

iiii. Cultivate a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design defects, and ensure the privacy and enhanced security of data and resources.

---

# **Informal Code Review**
*Overview:*

All three artifacts are included in my code review video. I conduct an individual analysis of each artifact to identify vulnerabilities, errors, and weaknesses. During the tour of each artifact, I provide a narrative that outlines my intentions for enhancements and improvements. I navigated through my C++ code in Visual Studio in the context of software design and engineering, providing an explanation of the process of converting it to Python. I discussed any potential enhancements to the original coding that could have been implemented. I once again employed Visual Studio to guide me through the C++ coding of the 2D triangle in my original artifact for algorithms and data structures. Identifying all beneficial coding blocks and shortcomings. Finally, I reviewed my Java coding in Eclipse for Databases, ensuring that I identified any coding or best practices weaknesses that I encountered. I also provided an explanation of the transition from hashmaps to a SQL database to ensure its permanence. 

<iframe align="center" width="900" height="480" src="https://www.youtube.com/embed/fNH1juXYmHw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

---

# Artifact 1 Software Engineering and Design
*Introduction:*

The artifact I have chosen for Enhancement One: Software Design and Engineering is a banking simulator application that was initially developed in C++. The program will calculate compounded interest for a specified number of years, regardless of whether monthly deposits are made.

I selected this artifact because of its intricate equations in C++ and my desire to expand my knowledge and boundaries by converting it to Python. I have only taken one Python course during my time at SNHU. I believed that this conversion would serve as a measure of my proficiency in a coding language that I had only been exposed to for eight weeks. 

**Click here to view the full narrative** \| [(View Narrative)](https://github.com/Noxx12/Noxx12.github.io/blob/master/Narratives/Milestone%20Two%20Narrative%20Kelly%20Perez.docx)

**Click here to view the code**
  - [Banking Simulator Original Code](https://github.com/Noxx12/Noxx12.github.io/blob/master/CS-499%20Software%20Engineering%20and%20Design/BankingApp.sln)
  - [Banking Simulator Final Code](https://github.com/Noxx12/Noxx12.github.io/blob/master/CS-499%20Software%20Engineering%20and%20Design/BankApp.py)

 *Conclusion:*

The transition from C++ to Python involved adapting the code to Python's simpler syntax, dynamic typing, and modern programming conventions. Variable declarations were moved into an __init__() constructor for better encapsulation, replacing C++'s explicit type declarations. Input handling shifted from cin to Python’s input() with added error handling via try-except blocks, ensuring robust user interaction. Output formatting was simplified using Python’s f-strings instead of fixed and setprecision. Loops were streamlined with Python’s range() function, and repetitive logic in interest calculations was refactored into reusable helper methods, improving maintainability. The main execution flow used Python's if __name__ == "__main__": standard, making the program modular and portable. These changes enhanced readability, modularity, and robustness, showcasing Python’s efficiency and flexibility.

---

# Artifact 2 Algorithms and Data Structures
*Introduction:*



The artifact I have chosen for Enhancement Two: Algorithms and Data Structure is a 2D representation of a triangle that was originally developed in OpenGL and C++. I developed this program during my time in CS 330 and believed that it would be advantageous for the implementation of Dijkstra's Algorithm.

I incorporated a modular function that computes the shortest paths from a source node to all other nodes in a weighted graph, which is represented as an adjacency list, in order to implement Dijkstra's Algorithm. This function employs a priority queue to efficiently retrieve and process the node with the minimum distance, updating the distances and predecessors of its neighbors as necessary. Furthermore, I incorporated a sample graph into the code to illustrate the algorithm's functionality. The modifications guarantee that the algorithm functions independently of the OpenGL rendering process, thereby preserving the original graphical output and incorporating a computationally significant algorithm. This modular approach improves the program by integrating advanced algorithm implementation with visual rendering, thereby showcasing both computational and graphical proficiency.


**Click here to view the full narrative** \| [(View Narrative)](https://github.com/Noxx12/Noxx12.github.io/blob/main/Narratives/Milestone%20Four%20Narrative%20Kelly%20Perez.docx)

  - [Triangle Original Code](https://github.com/Noxx12/Noxx12.github.io/blob/e2a3c8f2576e7b4980141ea975c065101c35d828/CS-499%20Algorithms%20and%20Data%20Structures/TriangleOriginal.cpp)
  - [Triangle Final Code](https://github.com/Noxx12/Noxx12.github.io/blob/masterain/CS-499%20Algorithms%20and%20Data%20Structures/Triangle.cpp)

*Conclusion:*

In summary, the integration of Dijkstra's Algorithm into the current OpenGL program underscores the equilibrium between computational problem-solving and graphical representation, illustrating the ability to combine algorithms with visual output. This project demonstrates my proficiency in the development of well-structured, adaptable, and efficient software solutions, as well as my understanding of advanced data structures, algorithm optimization, and modular coding practices. This integration is a testament to my ability to address intricate challenges in real-world applications and my proficiency in computer science. My code enhancements and this narrative align with this course outcome. It demonstrates my ability to apply algorithmic principles, adhere to computer science practices, and manage trade-offs in my design choices, showcasing an understanding of said concepts.

---

# Artifact 3 Databases
*Introduction:*

The artifact for Enhancement Three: Databases is a Contact Management System that is intended to manage critical operations, including the addition, updating, retrieval, and deletion of contact information. It illustrates the foundational principles of software development, such as database integration, data validation, and object-oriented programming. The system is constructed with a focus on maintainability and scalability, utilizing clean code practices and robust error management. This project demonstrates the ability to create secure and efficient software solutions while adhering to the most effective design and implementation practices.

The Contact Management System's scalability, data persistence, and query capabilities were significantly enhanced by the transition from a HashMap to a SQL database. Although the HashMap offered in-memory storage that was suitable for basic, temporary data handling, it lacked permanence and advanced retrieval options. The system now supports comprehensive data storage, ensuring that information is securely maintained across sessions, as a result of the integration of a SQL database. Furthermore, SQL enables the efficient manipulation and retrieval of larger datasets by facilitating the creation of complex queries and relationships. This improvement ensures that the system is consistent with the standards of real-world applications, thereby increasing its adaptability and dependability.

**Click here to view the full narrative** \| [(View Narrative)](https://github.com/Noxx12/Noxx12.github.io/blob/main/Narratives/Milestone%20Four%20Narrative%20Kelly%20Perez.docx)

  - [Contact Original Code](https://github.com/Noxx12/Noxx12.github.io/tree/master/CS-499%20Databases/Contact%20Original)
  - [Contact Final Code](https://github.com/Noxx12/Noxx12.github.io/tree/master/CS-499%20Databases/Contact%20Enhanced)

*Conclusion:*

The Contact Management System artifact is a testament to my software development expertise, demonstrating my capacity to develop, implement, and improve functional applications. The artifact demonstrates my dedication to the development of scalable and maintainable systems by incorporating SQL for robust data storage and administration, in addition to secure coding practices. This assignment emphasizes my ability to adhere to industry best practices and demonstrate my proficiency in object-oriented programming, database interaction, and system validation. In conclusion, this artifact not only exemplifies my technical proficiency but also emphasizes my preparedness to confront real-world challenges in the field of computer science.


