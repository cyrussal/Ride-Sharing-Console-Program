/*
MIS350 - DL2
Group Project Team 3
05/10/2023
Cyrus, Andrew, Haleem
This class will hold various information about a post. Posts can be dynamically created by users in the program, but there
will also be 10 hard coded posts as well. Posts will also hold various methods to perform actions such as displaying their
information and adding user responses to their post.
*/
public class Post {
    private String userName = ""; // Specify the post creators username.
    private String postType = ""; // Specify whether this post is asking for ride, or providing a ride.
    // Will be either "Asking For Ride" or "Providing Ride".
    private String locationStart = ""; // Set a pickup location.
    private String locationEnd = ""; // Set the drop-off location.
    private String pickUpMonth = ""; // Indicate the month of the year for the ride.
    private int pickUpDay; // The post will contain the day of the month the ride is scheduled for.
    private int militaryHour; // Set the pickup hour based on a 24-hour format (0000 - 2300).
    private String whoPaysGas = ""; // Specify the gas payee (Driver, Passengers, or Shared)
    private int numSeatsLeft; // Shows the available seats on a ride.
    private int numStops; // Number of stops on ride.
    private String comment = ""; // Optional comment made by the post creator
    private String responses[] = new String[10]; // Holds up to 10 responses from users inquiring about the post
    private int responsesIndex = 0; // Indicates how many response have been made

    private boolean isPostDisplayed = false; // Indicates whether or not the post has been displayed to
    // the user.

    // Constructor for Posts without hard-coded response
    public Post(String newUserName, String newPostType, String newLocationStart, String newLocationEnd, String newPickUpMonth,
                int newPickUpDay, int newMilitaryHour, String newWhoPaysGas, int newNumSeatsLeft, int newNumAdditionalStops,
                String newComment){
        userName = newUserName;
        postType = newPostType;
        locationStart = newLocationStart;
        locationEnd = newLocationEnd;
        pickUpMonth = newPickUpMonth;
        pickUpDay = newPickUpDay;
        militaryHour = newMilitaryHour;
        whoPaysGas = newWhoPaysGas;
        numSeatsLeft = newNumSeatsLeft;
        numStops = newNumAdditionalStops;
        comment = newComment;
    }

    // Constructor for Posts with hard-coded response
    public Post(String newUserName, String newPostType, String newLocationStart, String newLocationEnd,String newPickUpMonth,
                int newPickUpDay, int newMilitaryHour, String newWhoPaysGas, int newNumSeatsLeft, int newNumAdditionalStops,
                String newComment, String newResponses[], int newResponsesIndex){
        userName = newUserName;
        postType = newPostType;
        locationStart = newLocationStart;
        locationEnd = newLocationEnd;
        pickUpMonth = newPickUpMonth;
        pickUpDay = newPickUpDay;
        militaryHour = newMilitaryHour;
        whoPaysGas = newWhoPaysGas;
        numSeatsLeft = newNumSeatsLeft;
        numStops = newNumAdditionalStops;
        comment = newComment;

        // Takes all responses given from main method can sets them to the posts responses array
        for(int i = 0; i < newResponses.length; i++)
            responses[i] = newResponses[i];
        responsesIndex = newResponsesIndex;
    }

    // Displays all the posts information
    public void displayPost(int postNumber){
        String pickupDayCharacters = "";
        isPostDisplayed = true;
        // Below adds ending naming to dates, like May 2nd, or May 1st, May 23rd, etc.
        if(pickUpDay == 1 || pickUpDay == 21 || pickUpDay == 31)
            pickupDayCharacters = "st";
        else if(pickUpDay == 2 || pickUpDay == 22)
            pickupDayCharacters = "nd";
        else if(pickUpDay == 3 || pickUpDay == 23)
            pickupDayCharacters = "rd" ;
        else
            pickupDayCharacters = "th";

        // Display post information
        System.out.println("\n|----------------------------------------------------------------------|");
        System.out.println("Post #" + postNumber);
        System.out.println("\nPost Creator: " + userName);
        System.out.println("Post Type: " + postType);
        System.out.println("Location Start: " + locationStart);
        System.out.println("Location End: " + locationEnd);
        System.out.println("Pickup Month: " + pickUpMonth);
        System.out.println("Pickup Day: " + pickUpDay + pickupDayCharacters);
        System.out.println("Pickup Time (Military Hour): " + militaryHour);
        System.out.println("Who Pays Gas: " + whoPaysGas);
        System.out.println("Number Seats Left: " + numSeatsLeft);
        System.out.println("Number of Stops: " + numStops);
        System.out.print("Post Creator Comment: " + comment);

        // Display all responses a post has
        for(int  i = 0; i < responsesIndex; i++)
            System.out.printf("\nUser Response #%d: %s", i+1, responses[i]);
        System.out.println();
    }
    // Add a response to a post
    public void addResponse(String response){
        responses[responsesIndex] = response;
        responsesIndex++;
    }

    // GET METHODS
    public String getLocationStart() {
        return locationStart;
    }
    public String getLocationEnd() {
        return locationEnd;
    }
    public String getPickUpMonth() {
        return pickUpMonth;
    }
    public int getPickUpDay() {
        return pickUpDay;
    }

    public int getMilitaryHour() {
        return militaryHour;
    }
    public String getWhoPaysGas() {
        return whoPaysGas;
    }
    public String getPostType(){
        return postType;
    }
    public boolean isPostDisplayed() {
        return isPostDisplayed;
    }
    public int getNumStops() {
        return numStops;
    }
    // SET METHODS
    public void setPostDisplayed(boolean postDisplayed) {
        isPostDisplayed = postDisplayed;
    }
}