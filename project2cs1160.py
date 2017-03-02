#Project 2
#----------------
#100 pts

#Commenting is worth 10 points
#Finish the following functions to accomplish the goals stated in the comments


#Read a file into a list of words, return that list
#10 pts
def read_list(fileName):
	file1 = open(fileName) #Opens file and stores that file into a variable
	dataoffile = file1.read() #Reads data of file and stores that data into a variable in it's original state
	wordlist = dataoffile.split() #Takes all combined elements of the data and stores them into a list
	file1.close #Closes file
	wordlist = [x.replace("." , "") for x in wordlist] #Replaces periods with nothing

	return


#Read a file into a dictionary, where the key is the word and the value is the number of words
#10 pts
def read_dictionary(fileName):
	file1 = open(fileName)
	dataoffile = file1.read()
	wordlist = dataoffile.split()
	file1.close
	wordlist = [x.replace("." , "") for x in wordlist]
	worddictionary = {}	#Empty dictionary
	for element in wordlist: #Compares list to empty dictionary and fills that dictionary with the words in the list
		if element not in worddictionary:
			worddictionary[element] = 0		#Counter to add a 1 to the value of the keys in the dictionary for each element that is the same
		worddictionary[element] += 1
	return worddictionary

#print the top three words in fileName found in the file using a dictionary
#Formatted as such:
#The top three words in fileName are:
#word : number
#word : number
#word : number
#10 pts

def top_three_by_count(fileName):
	file1 = open(fileName)
	dataoffile = file1.read()
	wordlist = dataoffile.split()
	file1.close
	wordlist = [x.replace("." , "") for x in wordlist]
	worddictionary = {}
	for element in wordlist:
		if element not in worddictionary:
			worddictionary[element] = 0
		worddictionary[element] += 1
	print "The top three words in: ", fileName, "are"
	for key, value in sorted(worddictionary.iteritems(), reverse = True, key = lambda element:(element[1], element[0]))[:3]: #Creates a temporary function that aquires the first 3 sets of the sorted(by value) dictionary
   		print key, value
	return
#print the top three words in fileName found in the file using a dictionary
#Formatted as such:
#The first three words alphabetically in fileName are word word word
#10 pts

def top_three_by_alphabet(fileName):
	file1 = open(fileName)
	dataoffile = file1.read()
	wordlist = dataoffile.split()
	file1.close
	wordlist = [x.replace("." , "") for x in wordlist]
	worddictionary = {}
	for element in wordlist:
		if element not in worddictionary:
			worddictionary[element] = 0
		worddictionary[element] += 1
	sorteddict = (sorted(worddictionary)[:3])
	print 'First three words alphabetically in fileText.txt are: ',  str(sorteddict).replace(',','').replace("'",'')[1:-1]	#Turns sorted dictionary(3 keys) into a string and replaces commas with spaces
	return

#Count a given word in the file without using built-in functions
#return the count
#10 pts

def count_word(fileName, word):
	file1 = open(fileName)
	dataoffile = file1.read()
	wordlist = dataoffile.split()
	counter = 0
	for element in wordlist:	#Creates a counter. interates over the list, if the word matches it adds to the counter
		if element == word:
			counter += 1
		else:
			pass
	print counter
	return

	
#Use a dictionary to check if a word in the file
#retrun a boolean
#10 pts

def is_in_file(fileName, word):
	file1 = open(fileName)
	dataoffile = file1.read()
	wordlist = dataoffile.split()
	file1.close
	wordlist = [x.replace("." , "") for x in wordlist]
	if word in wordlist:	#If the word is in the list, it returns true. If word isn't in the list it returns false
		print word, 'in file'
		return True
	else:
		print word, "Not in file"
		return False
		quit()

	

#Find the unique count of words in the file
#return unique count
#10 pts

def unique_word_count(fileName):
	file1 = open(fileName)
	dataoffile = file1.read()
	wordlist = dataoffile.split()
	file1.close
	wordlist = [x.replace("." , "") for x in wordlist]
	print len(wordlist)	#Prints length of list
	return

#Use a list to remove a word from the file and rewrite the file without it
#Do not worry about spacing except between words
#10 pts

def remove_word_from_file(readFileName, writeFileName, word):
	file1 = open(readFileName)
	dataoffile = file1.read()
	wordlist = dataoffile.split()
	file1.close
	file2 = open(writeFileName,'w')
	for word in wordlist:	
		if word in wordlist:
			wordlist.remove(word)	#Removes specified word from list and writes the remaining words into a new file
		file2.write(str(word) + ' ' )	#Turns into string and adds a space

	else:
		file2.close
	

	return




#Make sure to call all the functions you wrote in order to test them
#10 pts

#top three count
top_three_by_count('fileText.txt')
#top three alphabet
top_three_by_alphabet('fileText.txt')
#count the word "in"
count_word('fileText.txt', 'in')
#Check if the word "in" is in the file
is_in_file('fileText.txt', 'in')
#Check if the word "asdef" is in the file
is_in_file('fileText.txt', 'asdef')
#Number of unique words in the file
unique_word_count('fileText.txt')
#Remove "and" from the file
remove_word_from_file('fileText.txt', 'fileText_word.txt', 'and')