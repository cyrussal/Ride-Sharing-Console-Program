/*
This program will allow users to upload posts to a social media platform to ask for a ride to a location.
At the beginning, the user is given a choice to find, create or see all available posts.
If looking for a particular post, the user is able to filter by eight different criteria to see if they can find a best match for their needs.
If creating a post, the user can enter detailed information about their ride and post it for other users to see.
After the user finds or creates a post, the user is given the option start the process all over again or simply end the program.
Any posts or responses to posts created in this program will be saved while the program is still running.
This allows users to search posts they have just made or commented on.
*/

import java.util.Scanner;
public class RideSharingApplication {
    public static void main(String[] args) {
        String userName = ""; // Specify the riders name
        String userPostType = ""; // Specify whether this post is asking for ride, or providing a ride.
        // Will be either "Asking For Ride" or "Providing Ride".
        String userLocationStart = "";// Set a pickup location.
        String userLocationEnd = ""; // Set a drop-off location.
        String userPickUpMonth = ""; // Indicate the month of the year for the ride.
        int userPickUpDay = 0; // User will enter a number indicate which day in the month they would like to be picked up.
        int userMilitaryHourEarliest = 0; // The earliest the user is willing to leave on the day of for their ride.
        int userMilitaryHourMax = 0; // The latest the user is willing to leave on the day of their ride share.
        int userMilitaryHour = 0; // User uses this variable for creating a post.
        String userWhoPaysGas = ""; // specify the gas payee (Driver, Passengers, or Shared).
        int userNumSeatsLeft = 0; // Show the available seats for a ride.
        int userNumStops = 0; // Shows the number of stops for a ride.
        String userComment = ""; // Optional comment on a post made by the user.
        int userNumPostsDisplayed = 0; // Keeps track of how many posts have been displayed to the user.
        // Resets to 0 during each iteration of the program.
        boolean restartProgram = true; // Restarts the program if set to true.
        // Default value is true to allow program to begin.
        boolean endProgram = false; // Ends program if set to true.
        // Default value is false to allow program to begin.
        int postIndex = 0; // Keeps tracks at what array index a new post will be created in the posts[] array object.
        int userInput = 0; // Used to store a numerical input from the user.
        Scanner scan = new Scanner(System.in); // Users to prompt user for input

        // Builds 10 hard-coded posts. 5 of them being "Asking for Ride" and 5 others being "Providing Ride" posts.
        Post[] posts = new Post[100];
        // Returns the number 10 and creates the hard coded posts.
        postIndex = createHardCodedPosts(posts);

        while (restartProgram == true && endProgram == false) {
            // Reset counter variables at start of program.
            userNumPostsDisplayed = 0;
            restartProgram = false;
            endProgram = false;
            setAllPostsToNotDisplayed(posts, postIndex); // Resets all post to not displayed mode. This prevent errors
            // when multiple iterations of this program are ran.

            // These variables dictate which questions will be asked when user is searching for a post.
            // We reset at every iteration of the program to reset the filters
            boolean filter1 = false, filter2 = false, filter3 = false, filter4 = false,
                    filter5 = false, filter6 = false, filter7 = false, filter8 = false;

            // Prompt user to either find, create, or display all posts.
            System.out.println("\nWelcome to the Ride Sharing Service!" +
                    "\nThis is where you will be able to create and find posts and connect to other users for ride sharing.\n");
            System.out.println("\nEnter 1 to find a post." +
                    "\nEnter 2 to create a post." +
                    "\nEnter 3 to see all available posts.");
            userInput = scan.nextInt();

            // PROCESS 1 - Find or create a post or display all posts.
            // Option 1: Find a Post by setting user criteria.
            if (userInput == 1) {
                scan.nextLine(); // Clears scanner from previous number input.

                // Set user criteria by asking user which filters to use.
                System.out.println("\nPlease type the number of each criteria you would like " +
                        "to search. You can cancel each criteria by re-typing it again.\n");

                System.out.println("Enter 1 to filter by the type of post " +
                        "(\"Asking for Ride\" or \"Providing Ride\")");
                System.out.println("Enter 2 to filter by starting location (Example: George Mason)");
                System.out.println("Enter 3 to filter by ending location");
                System.out.println("Enter 4 to filter by pickup month (Example: June)");
                System.out.println("Enter 5 to filter by pickup day (A Number of the day in the month)");
                System.out.println("Enter 6 to filter by pickup time (Military Hour)");
                System.out.println("Enter 7 to filter by who pays gas (Driver, Passengers, or Shared)");
                System.out.println("Enter 8 to filter by number of additional stops during ride");

                // This option will confirm the users filter selections.
                System.out.println("Enter 9 to confirm your selections. (You must select at least one" +
                        " filter for this program to function correctly)");

                // If the user selects a filter that is off, turn it on.
                // If the user selects a filter that is on, turn it off.
                while (userInput != 9) {
                    userInput = scan.nextInt();
                    if (userInput == 1) {
                        if (filter1 == false)
                            filter1 = true;
                        else
                            filter1 = false;
                    } else if (userInput == 2) {
                        if (filter2 == false)
                            filter2 = true;
                        else
                            filter2 = false;
                    } else if (userInput == 3) {
                        if (filter3 == false)
                            filter3 = true;
                        else
                            filter3 = false;
                    } else if (userInput == 4) {
                        if (filter4 == false)
                            filter4 = true;
                        else
                            filter4 = false;
                    } else if (userInput == 5) {
                        if (filter5 == false)
                            filter5 = true;
                        else
                            filter5 = false;
                    } else if (userInput == 6) {
                        if (filter6 == false)
                            filter6 = true;
                        else
                            filter6 = false;
                    } else if (userInput == 7) {
                        if (filter7 == false)
                            filter7 = true;
                        else
                            filter7 = false;
                    } else if (userInput == 8) {
                        if (filter8 == false)
                            filter8 = true;
                        else
                            filter8 = false;
                    }

                    // Display to user which filters are activated during each iteration of the while loop.
                    System.out.println("Post Type Filter: " + filter1 + "\n" +
                            "Location Start Filter: " + filter2 + "\n" +
                            "Location End Filter: " + filter3 + "\n" +
                            "Pickup Month Filter: " + filter4 + "\n" +
                            "Pickup Day Filter: " + filter5 + "\n" +
                            "Military Time Filter: " + filter6 + "\n" +
                            "Who Pays for Gas Filter: " + filter7 + "\n" +
                            "Number of Additional Stops Filter: " + filter8 + "\n");

                    // Remind user that entering 9 confirms their selections. Don't display this message if they have
                    // entered the number 9.
                    if(userInput != 9)
                        System.out.println("Enter 9 to confirm your selections");

                }
                scan.nextLine(); // Clears scanner from previous number input

                // End of selecting filter criteria

                // Select filtering questions based on users filter criteria
                if (filter1 == true) {
                    System.out.println("Are you asking for a ride or providing one? " +
                            "Enter \"Asking for Ride\" or \"Providing Ride\"");
                    userPostType = scan.nextLine();
                }
                if (filter2 == true) {
                    System.out.println("Please enter the starting location for your ride " +
                            "(Example: George Mason)");
                    userLocationStart = scan.nextLine();
                }
                if (filter3 == true) {
                    System.out.println("Please enter the ending location for your ride");
                    userLocationEnd = scan.nextLine();
                }
                if (filter4 == true) {
                    System.out.println("Please enter the pickup month for your ride (Example: June)");
                    userPickUpMonth = scan.nextLine();
                }
                if (filter5 == true) {
                    System.out.println("Please enter the pickup day for your ride (A Number of the day in the month)");
                    userPickUpDay = scan.nextInt();
                    scan.nextLine(); // Clears scanner from previous number input
                }
                if (filter6 == true) {
                    System.out.println("Please enter the earliest hour of the day that you can start the ride " +
                            "(Military Time: 0000 - 2300)");
                    userMilitaryHourEarliest = scan.nextInt();
                    System.out.println("Please enter the latest hour of the d  ay that you can start the ride " +
                            "(Military Time: 0000 - 2300)");
                    userMilitaryHourMax = scan.nextInt();
                    scan.nextLine(); // Clears scanner from previous number input
                }
                if (filter7 == true) {
                    System.out.println("Please enter who would pay gas for this ride " +
                            "(Driver, Passengers, or Shared)");
                    userWhoPaysGas = scan.nextLine();
                }
                if (filter8 == true) {
                    System.out.println("Please enter maximum number of additional stops that your" +
                            " ride can have");
                    userNumStops = scan.nextInt();
                    scan.nextLine(); // Clears scanner from previous number input
                }

            }
            // Option 2: User creates a post
            else if (userInput == 2) {
                scan.nextLine(); // Clears scanner from previous number input
                // User enters all post information
                System.out.println("\nAny posts created will be saved in this instance of" +
                        " the program\n");
                System.out.println("Please enter the username for this post");
                userName = scan.nextLine();
                System.out.println("Please enter post type (\"Asking for Ride\" or \"Providing Ride\")");
                userPostType = scan.nextLine();
                System.out.println("Please enter the starting location for your ride " +
                        "(Example: George Mason)");
                userLocationStart = scan.nextLine();
                System.out.println("Please enter the ending location for your ride");
                userLocationEnd = scan.nextLine();
                System.out.println("Please enter the pickup month for your ride (Example: June)");
                userPickUpMonth= scan.nextLine();
                System.out.println("Please enter the pickup day for your ride (A Number of the day in the month)");
                userPickUpDay = scan.nextInt();
                System.out.println("Please enter the hour of the day that your ride starts " +
                        "(Military Time: 0000 - 2300)");
                userMilitaryHour = scan.nextInt();
                scan.nextLine(); // Clears scanner from previous number input.
                System.out.println("Please enter who would pay gas for this ride " +
                        "(Driver, Passengers, or Shared)");
                userWhoPaysGas = scan.nextLine();
                System.out.println("Please enter the number seats you have available to passengers");
                userNumSeatsLeft = scan.nextInt();
                System.out.println("Please enter maximum number of additional stops that your" +
                        " ride will have");
                userNumStops = scan.nextInt();
                scan.nextLine(); // Clears scanner from previous number input.

                // Ask user if they would like to add a comment to their post.
                System.out.println("Would you like to enter a user comment for your post (Enter Yes or No)");
                if (scan.nextLine().equalsIgnoreCase("yes")) {
                    System.out.println("Please enter the user comment for your post");
                    userComment = scan.nextLine();
                }

                // Create a post object using input from the user.
                posts[postIndex] = new Post(userName, userPostType, userLocationStart, userLocationEnd,userPickUpMonth, userPickUpDay,
                        userMilitaryHour, userWhoPaysGas, userNumSeatsLeft, userNumStops, userComment);
                // Increase the next post's index by 1.
                postIndex++;
                System.out.println("\nCongrats! Your post as been created");

                // Prompt user to end or restart program
                System.out.println("If you would like to end the program, enter 1." +
                        "\nIf you would like to restart to program to find a post, press 2. (You can find the post you just made)");
                userInput = scan.nextInt();
                if (userInput == 1) {
                    endProgram = true;
                } else if (userInput == 2) {
                    restartProgram = true;
                }

            }

            // Option 3: Display all posts that have been created to the user.
            if (userInput == 3) {
                displayAllPosts(posts, postIndex);
                System.out.println("\nIf you would like to end the program, enter 1. " +
                        "\nIf you would like to restart the program, enter 2");
                userInput = scan.nextInt();
                if (userInput == 1) {
                    endProgram = true;
                } else if (userInput == 2) {
                    restartProgram = true;
                }
            }

            // PROCESS 2 - Apply Filtering and Display posts
            if (restartProgram == false && endProgram == false) {
                // Display all posts that match the user's criteria.
                // Some criteria will be in ranges of the user's defined criteria.
                // Filters that are turned off (false) won't impact the search filter.
                // If a match is made, display it.
                for (int i = 0; i < postIndex; i++) {
                    if ((posts[i].getPostType().equalsIgnoreCase(userPostType)
                            || !filter1) &
                            (posts[i].getLocationStart().equalsIgnoreCase(userLocationStart) || !filter2) &
                            (posts[i].getLocationEnd().equalsIgnoreCase(userLocationEnd) || !filter3) &
                            (posts[i].getPickUpMonth().equalsIgnoreCase(userPickUpMonth) || !filter4) &
                            (posts[i].getPickUpDay() == userPickUpDay || !filter5) &
                            ((posts[i].getMilitaryHour() >= userMilitaryHourEarliest &
                                    (posts[i].getMilitaryHour() <= userMilitaryHourMax) || !filter6) &
                                    (posts[i].getWhoPaysGas().equalsIgnoreCase(userWhoPaysGas) || !filter7) &
                                    (posts[i].getNumStops() == userNumStops || !filter8))
                    ) {
                        // Display post if criteria was met.
                        posts[i].displayPost(i + 1);
                        userNumPostsDisplayed++;
                    }
                }
                // Alerts user if no matching posts were found. Prompt to restart or end program.
                if (userNumPostsDisplayed == 0) {
                    System.out.println("\nNo posts matching your criteria were found");
                    System.out.println("\nIf you would like to restart the program, enter 1." +
                            "\nIf you would like to end the program, enter 2");
                    userInput = scan.nextInt();
                    if (userInput == 1) {
                        restartProgram = true;
                    } else if (userInput == 2) {
                        endProgram = true;
                    }
                }
                // If at least 1 post was found, prompt user to restart or continue program (To select a post).
                if(userNumPostsDisplayed >= 1) {
                    System.out.println("\n|----------------------------------------------------------------------|");

                    // Prompt user to end or restart program.
                    System.out.println("\nIf you would like to restart the program, enter 1." +
                            "\nIf you would like to continue the program to select a post to respond to, enter 2");
                    userInput = scan.nextInt();
                    if (userInput == 1) {
                        restartProgram = true;
                    } else if (userInput == 2) {
                        restartProgram = false;
                    }
                }

                // PROCESS 3 - User chooses a post to respond to.
                if (restartProgram == false && endProgram == false) {
                    // User selects which post to respond to with a message.
                    System.out.println("\nPlease enter a the number of the post your would like to " +
                            "respond to:");
                    userInput = scan.nextInt();
                    boolean postSelected = false;

                    // Wait until the user selects a post that was displayed to them
                    while (!postSelected) {
                        if (userInput <= postIndex & userInput >= 1) {
                            if (posts[userInput - 1].isPostDisplayed() == true) {
                                postSelected = true;
                                System.out.println("\nCongrats! You have selected a post");
                            } else {
                                System.out.println("Invalid response. Please try again");
                                userInput = scan.nextInt();
                            }
                        } else {
                            System.out.println("Invalid response. Please try again");
                            userInput = scan.nextInt();
                        }
                    }
                    scan.nextLine(); // Clears scanner

                    // After selecting a valid post, user enters a message to the post that they chose.
                    System.out.println("\nPlease enter a message that will be sent to the creator of the" +
                            " post you selected");
                    // Adds the users response to the post they chose.
                    posts[userInput - 1].addResponse(scan.nextLine());

                    System.out.println("\nCongrats! Your response has been added to the post you selected");

                    // User either restarts or ends the program
                    System.out.println("\nIf you would like to restart the program enter 1.\n" +
                            "If you would like to end the program, please enter 2.");
                    userInput = scan.nextInt();
                    if (userInput == 1) {
                        restartProgram = true;
                    } else if (userInput == 2) {
                        endProgram = true;
                    }
                }
            }
        }
    }

    // Display all user created and hard-coded posts.
    public static void displayAllPosts(Post[] posts, int postIndex) {
        for (int i = 0; i < postIndex; i++)
            posts[i].displayPost(i + 1);
    }

    // Creates 10 hard coded posts and returns a number indicating how many posts were made.
    public static int createHardCodedPosts(Post[] posts) {
        // Initalize hardcoded "Asking For Ride" posts within an array of posts objects
        posts[0] = new Post("Bob", "Asking For Ride", "George Mason",
                "Virginia Tech", "May" , 30, 1300,
                "Shared", 5, 0, "Looking for" +
                " someone to drive me from George Mason to Virginia Tech on the 30th of May at 1:00 PM" +
                "(13:00).\nThis is so I can visit my sisters graduation and it would be much appreciated",
                new String[]{"Hi. Can I take up this offer?", "Hmm, can you pay for the gas and ill come?"},
                2);
        posts[1] = new Post("Jim", "Asking For Ride", "Fairfax",
                "Richmond", "May", 20, 1200,
                "Passengers", 2, 1, "Looking for" +
                " from Fairfax to Richmond to visit my daughter on her Birthday. Willing to pay for " +
                "full cost of the ride");
        posts[2] = new Post("Jacob", "Asking For Ride", "Haymarket",
                "Fairfax", "June",10, 400,
                "Driver", 4, 2, "Looking for " +
                "ride from Haymarket to Driver. I'm broke so I can't pay for gas." +
                "(13:00).\nThis is so I can visit my daughter on her birthday and this would be much appreciated.");
        posts[3] = new Post("Alejandro", "Asking For Ride", "Sterling",
                "Washington DC", "May", 15, 1300,
                "Passengers", 1, 0, "Looking for" +
                " someone to to DC from Sterling. I have a business conference I need to attend to." +
                "(13:00). This is so I can visit my sisters graduation and it would be much appreciated");
        posts[4] = new Post("Chase", "Asking For Ride", "George Mason",
                "Fairfax", "June", 21, 1200,
                "Shared", 3, 0, "Looking for" +
                " someone to drive me from George Mason to Virginia Tech on the 30th of May at 1:00 PM" +
                "(13:00). This is so I can visit my sisters graduation and it would be much appreciated");

        // Add hardcoded posts for "Providing Ride"
        posts[5] = new Post("Dennis", "Providing Ride", "George Mason",
                "Manassas", "May",20, 500,
                "Passengers", 4, 0, "Driving to Mnassas to" +
                "see my family for the weekend. Willing to drive up to 4 others from GMU is y'all can pay gas",
                new String[]{"Hello. I would love to join you.", "I want to go but can't afford the gas"},
                2);
        posts[6] = new Post("Cyrus", "Providing Ride", "Fairfax",
                "Virginia Tech", "June", 2, 200,
                "Driver", 3, 4, "Got some errands" +
                " to run that happen to take me to Virginia Tech. Willing to pay for gas");
        posts[7] = new Post("Azir", "Providing Ride", "Reston",
                "Washington DC", "May", 13, 800,
                "Shared", 1, 0, "Driving to see " +
                "some friends in DC. Have room for one more in my convertible" +
                "(13:00).\nThis is so I can visit my daughter on her birthday and this would be much appreciated.");
        posts[8] = new Post("Haleem", "Providing Ride", "Sterling",
                "Reston", "May", 15, 1300,
                "Passengers", 1, 0, "Going to " +
                "to Sterling from Reston. Can provide ride.");
        posts[9] = new Post("Andrew", "Providing Ride", "George Mason",
                "Virginia Commonwealth University", "June",14, 900,
                "Driver", 2, 2, "Driving to VCU" +
                " since im transfering over. I can pay for has for this trip, but only have 2 seats left.");
        return 10; // We've created 10 hard-coded posts, so the number 10 indicates what array index
        // the next posts we will created in
    }

    // Sets all posts to not displayed
    public static void setAllPostsToNotDisplayed(Post posts[], int postIndex){
        for (int i = 0; i < postIndex; i++)
            posts[i].setPostDisplayed(false);
    }
}
