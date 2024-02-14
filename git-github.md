### Git & Github

Git
- SCM (Source Code Management) tool
- It is open source
- Developed and Maintained by Open Source community
- First curated by "Linus Torvalds" - Man behind linux kernel.
- Distributed Version Control System

GitHub
- Cloud Hosting Platform created for Projects that use Git
- Maintained by Microsoft 
- Microsoft acquired github in 2019 for 8 Billion Dollars.

What is a Version control System ?


A Version Control System (VCS) is a software tool that helps you track and manage changes to files over time. It's like a giant "undo/redo" button for your code, design files, documents, or any other digital asset. Here's what VCS offers:

1. Version History: VCS records every change made to a file, allowing you to revert to any previous version if needed. Imagine accidentally deleting a section of code – with VCS, you can easily go back to any point in time and retrieve it.

2. Collaboration: Multiple people can work on the same project simultaneously, with VCS ensuring everyone's changes are tracked and integrated seamlessly. No more confusion about who modified what and when.

3. Branching and Merging: VCS allows you to create different versions of your project (branches) to experiment with features or bug fixes without affecting the main branch. When satisfied, you can merge the changes back into the main branch.

4. Conflict Resolution: When multiple people modify the same file, VCS helps identify and resolve conflicts, ensuring smooth integration of changes.

5. Security and Auditing: VCS provides a security blanket by preventing accidental modifications and offering a complete history of who made changes when.

Common types of VCS:

**Centralized VCS:** Stores all versions in a central server (e.g., Subversion, GitLab).
**Distributed VCS:** Each user has a complete copy of the history locally (e.g., Git, Mercurial).


Centralized Version Control Systems (CVCS):

Central Repository: All versions of the project are stored in a central server.
Single Access Point: Developers interact with the central server to commit changes, checkout files, and track history.
Branching: Branching and merging can be complex and require server interactions.
Offline Work: Limited or no offline capabilities, requiring constant server connection.
Examples: Subversion, Perforce, CVS
Distributed Version Control Systems (DVCS):

Local Repository: Each developer has a complete copy of the repository on their local machine.
No Central Server (optional): Can operate without a central server, but often use one for collaboration.
Branching: Easy and lightweight branching and merging due to local copies.
Offline Work: Full functionality available offline, with changes pushed to the central server later.
Examples: Git, Mercurial, Bazaar
Here's a table summarizing the key differences:

|Feature|CVCS|DVCS|
|--|--|--|
|Repository	|Centralized server|	Distributed, local copy on each machine|
|Access Point|	Single server|	Local and optional central server|
|Branching|	Complex, server-dependent|	Easy and lightweight|
|Offline Work|	Limited	|Full functionality|
|Collaboration|	Server-centric|	More flexible|
|Examples|	Subversion, Perforce, CVS	| Git, Mercurial, Bazaar|

**Install Git**
[Click the link](https://git-scm.com/) and download the git software

Great [e-book](https://git-scm.com/book/en/v2) to read to learn everything about git and how to use it for github or any other hosting platform such as gitlab, bitbucket and etc.,

**Commands On Git - Initial Set Up**

Two basic commands to run
1. Would let git know who you are
- git config --global user.name "Your Name"
- git config user.name

2. Would let git know your email id 
- git config --global user.email "youremail@google.com"
- git config user.email 

**Commands on Git - Local SCM**
*What is a repository ?*

*A Git repository, in its strict definition, refers to the .git folder within your project directory. This hidden folder stores all the metadata Git uses to track changes, branches, commits, and the revision history of your project files*

*How do we create a repository ?*

- git init

*Process to follow to store your files in the repository*
Three Folders (Two Existent, one Imaginary)
1. Bring all the files (newly created or modified) into a staging area (All the files that are to be saved should be first get moved to staging area) from Working Directory
2. Commit (save the snapshot) into the repository which saves all the files from staging area

if you want to know, if the project files that you created or modified recently are present in staging area, run the following command
- git status

Command to move the files to staging area
- git add filename.extension
- git add filename1.extension filename2.extension . . .
- git add .

remove the files from staging area
- git rm --cached filename.extension

Save the files to repository
- git commit -m "Short simple message"

**Important Point:** whenever you save the project into the repository a new hash key (that is unique) is generated. Generaly these hashkeys are 40 bit character length. Using these hash keys, you can switch between versions. 

Check the history of your commits
- git log
- git log --oneline

Switch between commits
- git checkout CommitHashKey

**Working with Remote Repositories**


*Step 1*: Create a repository on github
*Step 2*: After creating the repository, get the link of the repository (Important Note: Do not initialize ReadMe.Md).
*Step 3*: On your local repository add this link as a remote so that push and pull will happen through this link.
- Check if a remote is available on the local repository
    - git remote
- add a new remote using the following command
    - git remote add var_name link
    - git remote add gitbasics https://github.com/tpkreddy/Git-Basics.git
- Push the changes to the remote repository
    - git push gitbasics 
- Pull the changes from the remote repository
    - git pull gitbasics master

---

**Additional Resources to Use**
[Github Cheatsheet](https://education.github.com/git-cheat-sheet-education.pdf) has all the useful commands

[Github - Markdown syntax cheat sheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)




