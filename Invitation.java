public class Invitation {
    private String hostName;
    private String address;
    public Invitation (String n, String a) {
        hostName = n;
        address = a;
    }
    public String getHostName() {
        return hostName;
    }
    public void setAddress(String a) {
        address = a;
    }
    public String invitationLetter(String invited) {
        return "Dear "+invited+", please attend my event at "+address+". See you then, "+hostName+".";
    }
    public Invitation(String address) {
        this.address = address;
        hostName = "Host";
    }
}