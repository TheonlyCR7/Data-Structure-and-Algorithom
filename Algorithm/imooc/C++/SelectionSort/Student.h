//
// Created by just it on 2020/5/7.
//

#ifndef SELECTIONSORT_STUDENT_H
#define SELECTIONSORT_STUDENT_H

#include <iostream>
#include <string>
using namespace std;

struct Student{
    string name;
    int score;

    bool operator<(const Student &otherStudnet){
        return score < otherStudnet.score;
    }
    friend ostream& operator<<(ostream &os, const Student &student){

        os<<"Student: "<<student.name<<" "<<student.score<<endl;
        return os;
    }
};
#endif //SELECTIONSORT_STUDENT_H
