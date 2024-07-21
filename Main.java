package emk;
public class Main {
    public static void main(String[] args) {
    	System.out.println("Welcome to Evaru Meelo kotieshwaruduu");
		System.out.println("--------------------------------------");
		System.out.println("Game Rules:"+"\nWe have total 15 Questions and You can win upto 1 crore."+
		                    " In this process you can utilize three life lines i.e., \ni. Phone-A-Friend\nii.50-50\niii.Audience poll."+
							" This will helps you answer the question");
		System.out.println("---------------------------------------");
        Question q1 = new Question("What is the capital of Andhrapradesh?", "Amaravathi", "Kurnool", "Vizag", "Amaravathi", "Guntur");
        Question q2 = new Question("Anti-clockwise moves in which direction?","Left","Up","Left","Right","Down");
        Question q3 = new Question("What is the capital of India?","Delhi", "Mumbai", "Delhi", "Lucknow", "Amaravathi");
        Question q4 = new Question("Who directed the movie named 'RRR'?","SS Rajamouli", "Sukumar", "Koratala Siva", "SS Rajamouli", "Ram Gopal Varma");
        Question q5 = new Question("In what galaxy is our solar system located?", "Milky Way", "Galaxy", "Earth", "Milky Way", "White Way");
        Question q6 = new Question("Which element has the chemical symbol 'O'?", "Oxygen", "Gold", "Oxygen", "Osmium", "Oganesson");
        Question q7 = new Question("What is the shortest month of the year?", "February", "June", "July", "January","February");
        Question q8 = new Question("Who is the cheif minister of Andhrapradesh?", "Chandra Babu", "Pawan Kalyan", "Jagan Mohan Reddy", "Lokesh", "Chandra Babu");
        Question q9 = new Question("What is the world's smallest continent?", "Australia", "Australia", "Africa", "Asia", "America");
        Question q10 = new Question("In what year did the Titanic sink?", "1912", "1812", "1712", "1912", "2012");
        Question q11 = new Question("What is the largest mammal in the world?", "Blue Whale", "Elephant", "Giraffe", "Blue Whale", "Great White Shark");
        Question q12 = new Question("What is the hardest rock?", "Diamond", "Granite", "Diamond", "Basalt", "Marble");
        Question q13 = new Question("Which country is known as the Land of the Rising Sun?", "Japan", "China", "Japan", "South Korea", "Thailand");
        Question q14 = new Question("Who claimed he could 'drive away the devil with a fart?'", "Martin Luther", "Thomas Edison", "Nikola Tesla", "Martin Luther", "James Watt");
        Question q15 = new Question("Where does the majority of Earth's energy come from?", "Sun", "Water", "Wind", "Sun", "Chemicals");

        Question[] questions = {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15};

        Quiz quiz = new Quiz(questions);
        quiz.runQuiz();
    }
}
