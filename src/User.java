// Change Log for Milestone 2
// Password property and methods have been added to achieve password protection for every user
// UserMenu class became User class and its parent class for all user classes

//Parent class for all users
public class User {

    private String ID;
    private String name;
    private String password;

    User(String name, String password){
        this.ID=RandomUID.generateRandomID();
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "ID='" + ID + '\'' +
                ", name='" + name + '\'';
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
        if(this.password.equals(inputPassword)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkID(String inputID) {
        if(this.ID.equals(inputID)){
            return true;
        }
        else {
            return false;
        }
    }

}



