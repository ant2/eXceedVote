create table ballot (
  id                        integer not null,
  voted_at                  timestamp,
  voter_id                  integer,
  criterion_id              integer,
  project_id                integer,
  votes                     integer,
  constraint pk_ballot primary key (id))
;

create table criterion (
  id                        integer not null,
  name                      varchar(255),
  vote_event_id             integer,
  constraint pk_criterion primary key (id))
;

create table project (
  id                        integer not null,
  name                      varchar(255),
  description               varchar(255),
  vote_event_id             integer,
  constraint pk_project primary key (id))
;

create table vote_event (
  id                        integer not null,
  name                      varchar(255),
  start_time                timestamp,
  finish_time               timestamp,
  announcement_time         timestamp,
  constraint pk_vote_event primary key (id))
;

create table voter (
  id                        integer not null,
  student_id                varchar(255),
  name                      varchar(255),
  vote_event_id             integer,
  constraint pk_voter primary key (id))
;

create sequence ballot_seq;

create sequence criterion_seq;

create sequence project_seq;

create sequence vote_event_seq;

create sequence voter_seq;

alter table ballot add constraint fk_ballot_voter_1 foreign key (voter_id) references voter (id);
create index ix_ballot_voter_1 on ballot (voter_id);
alter table ballot add constraint fk_ballot_criterion_2 foreign key (criterion_id) references criterion (id);
create index ix_ballot_criterion_2 on ballot (criterion_id);
alter table ballot add constraint fk_ballot_project_3 foreign key (project_id) references project (id);
create index ix_ballot_project_3 on ballot (project_id);
alter table criterion add constraint fk_criterion_voteEvent_4 foreign key (vote_event_id) references vote_event (id);
create index ix_criterion_voteEvent_4 on criterion (vote_event_id);
alter table project add constraint fk_project_voteEvent_5 foreign key (vote_event_id) references vote_event (id);
create index ix_project_voteEvent_5 on project (vote_event_id);
alter table voter add constraint fk_voter_voteEvent_6 foreign key (vote_event_id) references vote_event (id);
create index ix_voter_voteEvent_6 on voter (vote_event_id);


