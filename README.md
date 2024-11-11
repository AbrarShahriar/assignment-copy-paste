# BRACU CSE assignment copy paster

<p align="center">
Copy pasting each java assignment from different files is cumbersome and annoying. So, I created this little script to automate this process.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-v7+-teal?style=for-the-badge">&nbsp;
  <img src="https://img.shields.io/badge/MIT-green?style=for-the-badge">&nbsp;
</p>

## 📝 Requirements

- <strong>JAVA version 7 or up</strong> <br>

This script was made and tested in **JAVA version 22**

## ⚠️ READ THIS!!

You have to follow certain rules to not run into any errors.

- Your files **MUST** follow this naming convention: `TaskX.java`

```
Task1.java
Task2.java
Task3.java
...
TaskX.java
```

- Place all your assignment `.java` files in a new folder e.g. `assignment1`
- Place `GenerateTxt.java` and `assignment1` next to each other:

```
<your folder>
├── GenerateTxt.java
└── assignment1
    ├── Task1.java
    ├── Task2.java
    ├── Task3.java
    ├── ...
    └── TaskX.java
```

- The generated `.txt` file will have this format: `Assignment XX_studentID_YourName.txt`. This is the current assignment file naming convention BRACU is following.

## ⚡ Usage

1. Make sure the `GenerateTxt.java` file and assignment folder are in the same parent folder.
2. Compile `GenerateTxt.java` by running this command:

```
javac GenerateTxt.java
```

3. Run the script using this command:

```
java GenerateTxt
```

4. Go through each prompt:

```
Student Name: Your Name
Student ID: 24301500
Assignment Number: 01
Folder Name: assignment1
Assigment text file created successfully!
```

The above command will generate a file named
`Assignment 01_24301500_Your Name.txt` in the parent folder next to `GenerateTxt.java`.

5. If you have a folder structure like this:

```
<your folder>
├── GenerateTxt.java
├── Task1.java
├── Task2.java
├── Task3.java
├── ...
└── TaskX.java
```

Then input `./` in the `Folder Name` parameter.

## Before you go

<p align="center">
Feel free to modify the script to fit your needs.
If this repo helped you then give it a ⭐!
</p>
