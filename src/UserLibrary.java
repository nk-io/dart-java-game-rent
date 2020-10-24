import java.util.ArrayList;

abstract class UserLibrary {
    private ArrayList<User> userList = new ArrayList<>();

    public void addUserToList(User newUser){
        userList.add(newUser);
    }
    public ArrayList<User> getUsers(){
        return userList;
    }


    public User doesUserExist(String idToSearch){
        for (User user : userList) {
            if (user.getID().equals(idToSearch)) {
                return user;
            }
        }
        return null;
    }


    public boolean removeUser(String idToRemove){
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getID().equals(idToRemove)) {
                userList.remove(i);
                return true;
            }
        }
        return false;
    }


    public String listAll(){
        if(userList.size() < 1){
            return null;
        } else {
            StringBuilder listOfAll = new StringBuilder();
            for(int i=0; i<userList.size(); i++){
                listOfAll.append(userList.get(i).toString() + "\n");
            }
            return listOfAll.toString();
        }
    }


    public String getName(String enteredID){
        for (User user : userList) {
            if (user.checkID(enteredID)) {
                return user.getName();
            }
        }
        return null;
    }

}