// #include "Headers/Link.h"
#include <iostream>
#include <string>
// #include "Link.cpp"

#define RESET "\033[0m"
#define YELLOW "\033[33m"
#define GREEN "\033[32m"
#define BOLDYELLOW "\033[1m\033[33m"

using namespace std;

class Link
{
public:
    Link *next;
    string name;
    int value;
    Link()
    {
        this->next = NULL;
        this->value = 0;
        this->name = "";
    }

    void init(int id, string name, Link *next)
    {
        this->next = next;
        this->value = id;
        this->name = name;
    }

    void display()
    {
        cout << "{" << YELLOW << "value" << RESET << ": " << value << ", " << YELLOW << "name" << RESET << ": " << name << ", " << YELLOW << "self" << RESET << ": " << GREEN << this << RESET << ", " << YELLOW << "next" << RESET << ": " << GREEN << next << RESET << "}\n";
    }
};

class LinkList
{
private:
    Link *firstAddress;
    int size;

public:
    void InitLinkList()
    {
        this->size = 0;
        this->firstAddress = NULL;
    };

    bool IsEmpty()
    {
        return size == 0 ? true : false;
    };
    void removeFirst()
    {
        if (firstAddress != NULL)
        {
            Link *temp = firstAddress;
            firstAddress = temp->next;
            size -= 1;
            delete temp;
            cout << "Deleted " << temp << "\n";
        }
        else
        {
            firstAddress = NULL;
            size = 0;
            cout << "List is empty.\n";
        }
    };

    void clear()
    {
        while (firstAddress != NULL)
            this->removeFirst();
    }

    int length()
    {
        return this->size;
    }

    void insertFirst(int d, string s)
    {
        Link *temp = new Link();
        temp->init(d, s, firstAddress);
        firstAddress = temp;
        size += 1;
    }

    void insertToPosition(int value, string name, int position)
    {
        if (position >= 0 && position <= size)
        {
            Link *previousLink = firstAddress;
            if (position != 0)
            {
                for (int index = 1; index <= position; index++)
                {
                    if (index == position)
                    {
                        Link *newLink = new Link();
                        newLink->init(value, name, previousLink->next);
                        previousLink->next = newLink;
                        size += 1;
                        break;
                    }
                    else
                    {
                        if (previousLink->next != NULL)
                            previousLink = previousLink->next;
                    }
                }
            }
            else
            {
                this->insertFirst(value, name);
            }
        }
        else
        {
            cout << "Invalied index.\n";
        }
    }

    void insertTail(int value, string name)
    {
        if (size > 0)
        {
            this->insertToPosition(value, name, size);
        }
        else if (size == 0)
        {
            this->insertFirst(value, name);
        }
    }

    Link *getTail()
    {
        Link *currentLink = firstAddress;
        while (currentLink->next != NULL)
        {
            currentLink = currentLink->next;
        }
        return currentLink;
    }

    Link *getFirst()
    {
        return firstAddress;
    }

    Link *findByValue(int value)
    {
        Link *currentLink = firstAddress;
        while (currentLink->next != NULL)
        {
            if (currentLink->value == value)
                return currentLink;
            currentLink = currentLink->next;
        }
        if (currentLink->value == value)
            return currentLink;
        return NULL;
    }

    void print()
    {
        Link *currentLink = firstAddress;
        int index = 0;
        cout << "[\n";
        while (currentLink->next != NULL)
        {
            cout << "  " << BOLDYELLOW << index << RESET << ": {" << YELLOW << "value" << RESET << ": " << currentLink->value << ", " << YELLOW << "name" << RESET << ": " << currentLink->name << ", " << YELLOW << "self" << RESET << ": " << GREEN << currentLink << RESET << ", " << YELLOW << "next" << RESET << ": " << GREEN << currentLink->next << RESET << "}\n";
            currentLink = currentLink->next;
            index++;
        }
        cout << "  " << BOLDYELLOW << index << RESET << ": {" << YELLOW << "value" << RESET << ": " << currentLink->value << ", " << YELLOW << "name" << RESET << ": " << currentLink->name << ", " << YELLOW << "self" << RESET << ": " << GREEN << currentLink << RESET << ", " << YELLOW << "next" << RESET << ": " << GREEN << currentLink->next << RESET << "}\n";
        cout << "](" << size << ")\n";
    }
};

int main()
{

    LinkList links;
    links.InitLinkList();

    links.insertFirst(1, "index 0");
    links.insertFirst(1, "index 0");
    links.insertFirst(1, "index 0");
    links.insertFirst(1, "index 0");
    links.insertFirst(1, "index 0");

    links.removeFirst();

    // links.insertTail(4,"index 3");
    links.print();

    links.findByValue(1)->display();

    return 0;
}
