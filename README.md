# SortedNameWithJava
Same assessment for the unsorted-name-list.txt of LastNames and GivenNames
Two comparators with one NameSortWay Interface with Main function following SOLID principle
of OOP in Java

#Workflow
name: SortedNameWithJava

on:
  push:
    branches:
      - main

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout code
      uses: actions/checkout@v2

    - name: Set up JDK
      uses: actions/setup-java@v2
      with:
        java-version: '11'

    - name: Build your project
      run: |
        # Add your build commands here
        # For example, if you're using Gradle: ./gradlew build

    - name: Run tests
      run: |
        # Add your test commands here

  deploy:
    needs: build
    runs-on: ubuntu-latest

    steps:
    - name: Checkout code
      uses: actions/checkout@v2

    - name: Set up JDK
      uses: actions/setup-java@v2
      with:
        java-version: '11'

    - name: Deploy to Production
