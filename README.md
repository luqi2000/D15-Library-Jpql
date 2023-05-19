# D15-Library-Jpql

part 1)
Starting from LibraryCatalog (abstract) via strategy Joined book and magazines will inherit from LibraryCatalog the same id as primary key 
then parent and children will only have their own attributes in the tables


part 2)
User (main object)
Loans (sub-object)

OneToMany : user can have multiple checkouts (possible collection list)
ManyToOne: multiple loans can be made by one user

In the catalog we have both books and magazines.

OneToMany: 1 catalog (book or magazine) can have -> multiple loans (not in the same period of time).

ManyToOne: multiple loans can be made on a catalog (not in the same period of time).


The archive must allow the following operations:
- Adding a catalog item
- Removing a catalog item given an ISBN
- Search by ISBN
- Search by publication year
- Search by author
- Search by title or part of it
- Search for items currently on loan given a user card number
- Search for all overdue and not yet repaid loans
