This is my response to the Moogsoft Technical Test as outlined below:


Moogsoft Technical Test:
 
The candidate should spend no more than 3 hours to tackle the following problem:
 
The candidate needs to write a program that finds the 'X' most relevant words or phrases related to the movie "The Interview" (IMDB: http://www.imdb.com/title/tt2788710/), by parsing sources, it is up to the candidate how these sources are fed into the program.
The definition of what constitutes as a relevant word or phrase is at the discretion of the candidate.
 
The submission must compile and should therefore contain all source files and libraries to be able to run the program. It is better to send everything than have something missing.
The output should be an ordered list of the most relevant words or phrases to the standard-output (i.e. simply printed).
https://ci6.googleusercontent.com/proxy/RnNZfQn2o2xpggJQqefCOervMbPIci5mujDPJnvl43kv6Rtxjyh5gHN_JKVzeU-aaGz3pePFgxfoAAtZJZNx8mveVTc-11j98EfuAJVcumUenA=s0-d-e1-ft#https://ssl.gstatic.com/ui/v1/icons/mail/images/cleardot.gif
The submission should be coded in Java (Java 7+ should be used).
 
The submission does not need to contain unit tests or be "perfect" code, considering the time constraint.
You are free to use the internet during the exercise, but work should be carried out solely by the candidate.
The interviewers will ask questions about the submission.
 
3rd party library usage is allowed, but in moderation, i.e. you are allowed to use a library to help convert text from one format to another, but not allowed to use a library that "finds the most relevant words in a text source"... common sense should be applied here.








The commands to run it (once you are in the same directory) should be 

javac -cp ./jsoup.jar *.java
java -cp .:./jsoup.jar Main



This program has 2 components to it: a webscraper and a text processor. The webscraper is from 
jsoup. I made the text processor myself.

I basically fed in 5 default websites (more can be added manually), and used the jsoup scraper to
scrape the text from the website. I would store content in a temporary file for the text processor.

The text processor would then go through the file and count the instances of each word and put the unique 
words and values in a Hashmap, and then would go through a lot of different processing through different lists
to return the top X (default value is 10) occurences of words.

I was also considering accepting user input from the command line to make things more interesting so that more
websites could be added easily instead of having to do it manually from java, but I decided that would be a lot more
time than I could spare right now (finals week woohoo).


