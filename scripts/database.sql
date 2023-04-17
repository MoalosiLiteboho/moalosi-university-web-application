create database if not exists UniversityManagementSystem;

use UniversityManagementSystem;

create table if not exists AuthorityTable(
    Id int not null auto_increment,
    Role varchar(255) not null,
    primary key(Id)
);

create table if not exists DistrictTable(
    Code int not null,
    Name varchar(255) not null,
    primary key (Code)
);

create table if not exists UserTable(
    Id int not null,
    Name varchar(255) not null,
    Surname varchar(255) not null,
    Gender varchar(255) not null,
    DateOfBirth date not null,
    DistrictCode int not null,
    primary key(Id),
    foreign key(DistrictCode) references DistrictTable(Code)
);

create table if not exists UserAccountTable(
    UserId int not null,
    AuthorityId int not null,
    Username varchar(255) not null,
    Password varchar(255) not null,
    Enabled bit not null,
    primary key(UserId),
    foreign key(UserId) references UserTable(Id),
    foreign key(AuthorityId) references AuthorityTable (Id)
);

create table if not exists CourseTable(
    Id int not null auto_increment,
    InstructorId int not null,
    Name varchar(255) not null,
    Description varchar(255) not null,
    Type varchar(255) not null,
    CreationDate date not null,
    primary key(Id),
    foreign key(InstructorId) references UserTable(Id)
);

drop table AssigmentTable;
create table if not exists AssigmentTable(
    Id int not null auto_increment,
    CourseId int not null,
    Name varchar(255) not null,
    CreationDate date not null,
    DeadLine date not null,
    AssigmentPath varchar(255),
    primary key(Id),
    foreign key(CourseId) references CourseTable (Id)
);

create table if not exists SubmissionTable(
    Id int not null auto_increment,
    StudentId int not null,
    CourseId int not null,
    AssignmentId int not null,
    SubmittedPath varchar(255) not null,
    SubmissionDate date not null,
    primary key(Id),
    foreign key(StudentId) references UserTable (Id),
    foreign key(CourseId) references CourseTable(Id),
    foreign key(AssignmentId) references AssigmentTable(Id)
);

create table if not exists CourseMaterial(
    Id int not null auto_increment,
    CourseId int not null,
    Name varchar(255) not null,
    MaterialPath varchar(255) not null,
    primary key(Id),
    foreign key(CourseId) references CourseTable (Id)
);

create table if not exists StudentFeedBack(
    Id int not null auto_increment,
    CourseId int not null,
    Rating varchar(255) not null,
    FeedBack text not null,
    primary key(Id),
    foreign key(CourseId) references CourseTable (Id)
);

create table if not exists EnrollmentTable(
    Id int not null auto_increment,
    StudentId int not null,
    CourseId int not null,
    Enrollment date not null,
    primary key(Id),
    foreign key(StudentId) references UserTable (Id),
    foreign key(CourseId) references CourseTable(Id)
);

create table if not exists Announcement(
    Id int not null auto_increment,
    InstructorId int not null,
    Tittle text not null,
    CourseId int not null null,
    Announcement text null,
    CreatedDate date not null,
    primary key(Id),
    foreign key(CourseId) references CourseTable(Id),
    foreign key(InstructorId) references UserTable(Id)
);

create table if not exists StudentGrades(
    Id int not null auto_increment,
    CourseId int not null,
    AssignmentId int not null,
    StudentId int not null,
    Submitted bit not null,
    Marks int,
    Grade varchar(255),
    primary key(Id),
    foreign key(CourseId) references CourseTable(Id),
    foreign key(AssignmentId) references AssigmentTable(Id),
    foreign key(StudentId) references UserTable(Id)
);