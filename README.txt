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
