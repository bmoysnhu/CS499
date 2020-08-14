//============================================================================
// Name        : Milestone 3 Enhancement LinkedList.cpp
// Author      : BrandonMoy
// Version     : 1.0 Enhancement (7/26/2020)
// Copyright   : Copyright © 2017 SNHU COCE
// Description : 1.0 Enhance for CS 499
//============================================================================

#include <algorithm>
#include <iostream>
#include <time.h>

#include "CSVparser.hpp"

using namespace std;

//============================================================================
// Global definitions visible to all methods and classes
//============================================================================

// forward declarations
double strToDouble(string str, char ch);

// define a structure to hold bid information
struct Bid {
    string bidId; // unique identifier
    string title;
    string fund;
    double amount;
    Bid() {
        amount = 0.0;
    }
};

//============================================================================
// Linked-List class definition
//============================================================================

/**
 * Define a class containing data members and methods to
 * implement a linked-list.
 */
class LinkedList {

private:
    //Internal structure for list entries, housekeeping variables
	struct Node {
		Bid bid;
		Node* next;

		// Default constructor
		Node(){
			next = nullptr;
		}

		//initalize a node with a bid
		Node(Bid myBid){
			bid = myBid;
			next = nullptr;
		}
	};


	Node* head;
	Node* tail;
	int size = 0;


public:
    LinkedList();
    virtual ~LinkedList();
    void Append(Bid bid);
    void Prepend(Bid bid);
    void PrintList();
    void Remove(string bidId);
    Bid Search(string bidId);
    int Size();
};

/**
 * Default constructor
 */
LinkedList::LinkedList() {
    //Initialize housekeeping variables
	//set head, tail to nullptr for linked list use
	head = nullptr;
	tail = nullptr;
}

/**
 * Destructor
 */
LinkedList::~LinkedList() {
}

/**
 * Append a new bid to the end of the list
 */
void LinkedList::Append(Bid bid) {
    //  Implement append logic
	Node* node = new Node(bid);

	//if head is null assign it to node
	if (head == nullptr){
		head = node;
	}
	//else tail does not equal null go to next
	else {
		if (tail != nullptr){
			tail -> next = node;
		}
	}
	//new node is always the tail
	tail = node;
	size++;
}


/**
 * Prepend a new bid to the start of the list
 */
void LinkedList::Prepend(Bid bid) {
    //Implement prepend logic
	Node* node = new Node(bid);

	if (head != nullptr){
		node -> next = head;
	}

	head = node;

	size++;
}

/**
 * Simple output of all bids in the list
 */
void LinkedList::PrintList() {
    //Implement print logic
	//assigns current node to head
	Node* CURRENT = head;

	//while current node has a bid, it will print below
	while (CURRENT != nullptr){
		cout << CURRENT -> bid.bidId << ": " << CURRENT -> bid.title << " " << CURRENT -> bid.amount << " " << CURRENT -> bid.fund << endl;
		CURRENT = CURRENT -> next;
	}
}

/**
 * Remove a specified bid
 *
 * @param bidId The bid id to remove from the list
 */
void LinkedList::Remove(string bidId) {
    //Implement remove logic
	//if head not null compare node bid to the bid ID
	if (head != nullptr){
		if (head -> bid.bidId == bidId){
			Node* tempNode = head -> next;
			delete head;
			//current node point beyond the next node that is removed
			head = tempNode;
		}
	}
	//loops the list
	Node* CURRENT = head;
	//loop over each node looking for a match
		while(CURRENT -> next != nullptr){
			if (CURRENT -> next-> bid.bidId.compare(bidId)==0){
				//save the next node (one being removed
				Node* tempNode = CURRENT -> next;

				//current node point beyond the next node that is removed
				CURRENT -> next = tempNode -> next;

				//delete tempNode
				delete tempNode;

				//reduces count by 1
				size--;

				return;
			}
			CURRENT = CURRENT -> next;
		}

	}


/**
 * Search for the specified bidId
 *
 * @param bidId The bid id to search for
 */
Bid LinkedList::Search(string bidId) {
	Node* CURRENT = head;

	//compares CURRENT to input bid
	while(CURRENT != nullptr){
		if (CURRENT -> bid.bidId.compare(bidId)==0){
			return CURRENT ->bid;
		}

		//Enhancement 2 - The error message when inital bid id is not found
		else {
			cout << "Invalid Entry" << endl << "Displaying first bid in csv file" << endl;
			return CURRENT ->bid;

		}
		CURRENT = CURRENT -> next;

	}
}


/**
 * Returns the current size (number of elements) in the list
 */
int LinkedList::Size() {
    return size;
}

//============================================================================
// Static methods used for testing
//============================================================================

/**
 * Display the bid information
 *
 * @param bid struct containing the bid info
 */
void displayBid(Bid bid) {
    cout << bid.bidId << ": " << bid.title << " | " << bid.amount << " | " << bid.fund << endl;
    return;
}

/**
 * Prompt user for bid information
 *
 * @return Bid struct containing the bid info
 */
Bid getBid() {
    Bid bid;

    cout << "Enter Id: ";
    cin.ignore();
    getline(cin, bid.bidId);

    cout << "Enter title: ";
    getline(cin, bid.title);

    cout << "Enter fund: ";
    cin >> bid.fund;

    cout << "Enter amount: ";
    cin.ignore();
    string strAmount;
    getline(cin, strAmount);
    bid.amount = strToDouble(strAmount, '$');

    return bid;
}

/**
 * Load a CSV file containing bids into a LinkedList
 *
 * @return a LinkedList containing all the bids read
 */
void loadBids(string csvPath, LinkedList *list) {
    cout << "Loading CSV file " << csvPath << endl;

    // initialize the CSV Parser
    csv::Parser file = csv::Parser(csvPath);

    try {
        // loop to read rows of a CSV file
    	for (int i = 0; i < file.rowCount(); i++) {
            // initialize a bid using data from current row (i)
            Bid bid;
            bid.bidId = file[i][1];
            bid.title = file[i][0];
            bid.fund = file[i][8];
            bid.amount = strToDouble(file[i][4], '$');

            //cout << bid.bidId << ": " << bid.title << " | " << bid.fund << " | " << bid.amount << endl;

            // add this bid to the end
            list->Append(bid);
        }
    //error when csv file that is type is not found.
    } catch (csv::Error &e) {
        std::cerr << e.what() << std::endl;
    }
}

/**
 * Simple C function to convert a string to a double
 * after stripping out unwanted char
 *
 * credit: http://stackoverflow.com/a/24875936
 *
 * @param ch The character to strip out
 */
double strToDouble(string str, char ch) {
    str.erase(remove(str.begin(), str.end(), ch), str.end());
    return atof(str.c_str());
}

/**
 * The one and only main() method
 *
 * @param arg[1] path to CSV file to load from (optional)
 * @param arg[2] the bid Id to use when searching the list (optional)
 */
int main(int argc, char* argv[]) {

    // process command line arguments
    string csvPath, bidKey, userBidId, userCSV;


    switch (argc) {
    case 2:
        csvPath = argv[1];
        bidKey = "98109";
        break;
    case 3:
        csvPath = argv[1];
        bidKey = argv[2];
        break;
    default:
    	//Enhancement 1 - allow user to pick csv file
    	cout << "Choose 1:" << endl << "eBid_Monthly_Sales_DEC_2016.csv"<< endl << "eBid_Monthly_Sales.csv" << endl;
    	cin >> userCSV;
        csvPath = userCSV;
        //Enhancement 2 - allow user to pick bid id
        cout << "Enter Bid Id" << endl;
        cin >> userBidId;
        bidKey = userBidId; //will default to this bidId
    }

    clock_t ticks;

    LinkedList bidList;

    Bid bid;

    int choice = 0;
    while (choice != 9) {
    		cout << "Menu:" << endl;
    		cout << "  1. Enter a Bid" << endl;
    		cout << "  2. Load Bids" << endl;
    		cout << "  3. Display All Bids" << endl;
    		cout << "  4. Find Bid" << endl;
    		cout << "  5. Remove Bid" << endl;
    		//Enhancement 3 - Prepend functionality
    		cout << "  6. Prepend a Bid" << endl;
    		cout << "  9. Exit" << endl;
    		cout << "Enter choice: ";
    		cin >> choice;

    		switch (choice) {
    		case 1:
    			bid = getBid();
    			bidList.Append(bid);
    			displayBid(bid);

    			break;

    		case 2:
    			ticks = clock();

    			loadBids(csvPath, &bidList);

    			cout << bidList.Size() << " bids read" << endl;

    			ticks = clock() - ticks; // current clock ticks minus starting clock ticks
    			cout << "time: " << ticks << " milliseconds" << endl;
    			cout << "time: " << ticks * 1.0 / CLOCKS_PER_SEC << " seconds" << endl;

    			break;

    		case 3:
    			bidList.PrintList();

    			break;

    		case 4:
    			ticks = clock();

    			bid = bidList.Search(bidKey);

    			ticks = clock() - ticks; // current clock ticks minus starting clock ticks

    			if (!bid.bidId.empty()) {
                displayBid(bid);
                cout << "time: " << ticks << " clock ticks" << endl;
                cout << "time: " << ticks * 1.0 / CLOCKS_PER_SEC << " seconds" << endl;
    			}
    			else {
    				cout << "Bid Id " << bidKey << " not found." << endl;
    			}


    			break;

    		case 5:
    			bidList.Remove(bidKey);
    			cout << "Bid Removed"<<endl;

    			break;
    		//Enhancement 3 - Prepend functionality
    		case 6:
    			bid = getBid();
				bidList.Prepend(bid);
				displayBid(bid);

				break;
    		}
    }
    cout << "Good bye." << endl;
    return 0;
}
