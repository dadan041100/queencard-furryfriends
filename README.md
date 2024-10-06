## Open Command Prompt/Windows Powershell as Admin
- open cmd/win ps
- type CD and put the location of your directory where you want to clone
    ```
  [eg. cd C:\Users\<your username>\Documents\...]
    ```
- Hit Enter

## Clone this Repository
- Open your powershell/terminal and run:
    ```
    git clone [https://github.com/dadan041100/queencard-furryfriends.git]
    ```
- Open your project in IntelliJ 

## Set up MySQL in Docker
### Requirement: Docker Desktop  
- If you do not have Docker Desktop, kindly download it and set the respective paths to ensure that it is working.
- Log-in or Register with your GitHub or Personal Account
  
### Open your powershell/terminal
- Pull MySQL image from DockerHub  
    ```
    docker pull mysql
    ```
- Configure and Run MySQL in Docker  
    ```
    docker run -p 3307:3306 --name mysqlcontainer -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=qcard_furryfriends_db -d mysql
    ```
### Open the terminal in IntelliJ and run the following
- Pull MySQL image from DockerHub  
- Configure Network project's network  
    ```
    docker network create networkmysql
    ```
- Pull MySQL image from DockerHub  
- Connect project and mysql   
    ```
    docker network connect networkmysql mysqlcontainer
    ```

## Add Data Source in Project
- Open IntelliJ
- Open the "Database" on the top-right side pane
- Click the '+' icon
- Click Data Source > MySQL
- Configure the following:
  - User: `root`
  - Password: `root`
  - URL: `jdbc:mysql://localhost:3307/qcardfurry_friends_db`
- Test the connection, apply changes on success

## Initialize the Schema and Data of the Project
- Open furrydb.sql under `src/main/resources/`
- Connect to the data source `furry_friends_db@localhost`

## Reference:
- This set of instruction came from Danziel Cempron, specifically on how to set-up MySQL in Docker Desktop

  
