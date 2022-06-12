#include <string>

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
    Link();

    void init(int id, string name, Link *next);
    void display();

    ~Link();
}