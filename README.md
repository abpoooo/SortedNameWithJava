# SortedNameWithJava
Same assessment for the unsorted-name-list.txt of LastNames and GivenNames
Two comparators with one NameSortWay Interface with Main function following SOLID priciple
of OOP in java

#Workflow
name: Java CI/CD

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

    - name: Build with Maven
      run: mvn clean install

    - name: Run tests
      run: mvn test

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
      run: |
        # Add your deployment script/commands here
        # This could involve copying artifacts to a server or deploying to a cloud platform
