CREATE SCHEMA forum;

CREATE SEQUENCE forum.user_sequence;

CREATE TABLE forum.user (
    id bigint not null
        constraint user_id_pkey
        primary key
        default nextval('forum.user_sequence'),
    name varchar(255) not null,
    email varchar(512) not null,
    password varchar(255) not null
);

CREATE SEQUENCE forum.question_sequence;

CREATE TABLE forum.question (
    id bigint not null
        constraint question_id_pkey
        primary key
        default nextval('forum.question_sequence'),
    title varchar(512) not null,
    body varchar(1024) not null,
    author_id bigint not null,
    creation_date timestamp not null,
    foreign key (author_id) references  forum.user (id)
);

CREATE SEQUENCE forum.answer_sequence;

CREATE TABLE forum.answer (
    id bigint not null
        constraint answer_id_pkey
        primary key
        default nextval('forum.answer_sequence'),
    body varchar(1024) not null,
    question_id bigint not null,
    author_id bigint not null,
    answer_date timestamp not null,
    foreign key (question_id) references forum.question (id),
    foreign key (author_id) references  forum.user (id)
);
