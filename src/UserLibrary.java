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
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getID().equals(idToSearch)) {
                return userList.get(i);
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


    public boolean areThereAnyUsers(){
        return userList.size() != 0;
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
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).checkID(enteredID)){
                return userList.get(i).getName();
            }
        }
        return null;
    }

    // Updates user by removing old user object -> new updated user
    public boolean updateUser(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getID().equals(user.getID())) {
                userList.remove(i);
                userList.add(user);
                return true;
            }
        }
        return false;
    }


}
