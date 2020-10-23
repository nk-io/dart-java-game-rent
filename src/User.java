// Password property and methods have been added to achieve password protection for every user
// UserMenu class became User class and its parent class for all user classes

import exception.EmptyNameException;
import exception.EmptyPasswordException;

//Parent class for all users
abstract class User {

    private String ID;
    private String name;
    private String password;

    User(String name, String password) throws EmptyNameException, EmptyPasswordException {
        if(name.isEmpty()){
            throw new EmptyNameException(getClass().toString().split(" ")[1]);
        }
        if(password.isEmpty()){
            throw new EmptyPasswordException(getClass().toString().split(" ")[1]);
        }
        this.ID= RandomUID.generateRandomID();
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "ID= '" + ID + '\'' +
                ", name= '" + name + '\'';
    }

    public String getName(){
        return this.name;
    }
    public String getID() {
        return this.ID;
    }
    // setter for name property (in case of if we need it)
    public void setName(String name){
        this.name=name;
    }
    //Checks for the password for user
    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public boolean checkID(String inputID) {
        return this.ID.equals(inputID);
    }

}



