#include "Link.h"

Link::Link()
{
    next = NULL;
    value = 0;
    name = "";
}

Link::void init(int id, string name, Link *next)
{
    next = next;
    value = id;
    name = name;
}

Link::void display()
{
    cout << "{" << YELLOW << "value" << RESET << ": " << value << ", " << YELLOW << "name" << RESET << ": " << name << ", " << YELLOW << "self" << RESET << ": " << GREEN << this << RESET << ", " << YELLOW << "next" << RESET << ": " << GREEN << next << RESET << "}\n";
}

Link::~Link()
{
}
