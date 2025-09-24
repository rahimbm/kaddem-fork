<h1>Student Management System</h1>

<p id="description">Welcome to the Student Management System project, a comprehensive tool designed to streamline the management of student information in educational institutions. This system is built to simplify the tracking of students, their academic departments, contracts, and team assignments. With a rich set of features and a well-structured data model, it ensures efficient administration and organization of student data.</p>
<h1>Key Classes and Relationships</h1>

<h2>Student Class :</h2>

<p id="description">The Student class represents individual students enrolled in your educational institution. Each student is associated with the following:

 -Department: Students are linked to a specific academic department where they pursue their studies.

 -Team Assignment (Equipe): Students can be part of a team (equipe) within the institution, facilitating collaboration and group activities.

 -Contract: This class tracks the contract status of each student, such as enrollment contracts or agreements.

 -Option: An enumeration (enum) representing the chosen academic option or major of the student.
</p>

<h2>Contract Class :</h2>

<p id="description">The Contract class manages the contractual relationship between the educational institution and its students. Each contract includes information such as:

-Specialization: An enumeration (enum) specifying the specialization or program of study chosen by the student.</p>

<h2>Equipe (Team) Class :</h2>

<p id="description">The Equipe class represents teams or groups of students who collaborate on projects or activities within the institution. It includes:

 -Detail Equipe: A relationship to track detailed information about the team, its members, and activities.

 -Niveau (Level): An enumeration (enum) that categorizes teams by their academic level or grade.</p>
 
 <h2>Departement (Department)  Class :</h2>

 <p id="description">The Departement class represents academic departments within the educational institution. It maintains a unidirectional relationship with the Universite class, establishing the institution's organizational structure.

 -Universite (University): Represents the university or educational institution that houses multiple academic departments.</p>

<p align="center"><img src="https://i.postimg.cc/V6Ps842y/image-2023-09-16-154047632.png" alt="project-image"></p>
