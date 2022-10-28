use db_facebook;

insert into user (username, password) values ('pera', '123');
insert into user (username, password) values ('zika', '123');
insert into user (username, password) values ('igor', '123');

insert into post (description, picture_path, video_path, date_time, user_id, views) values ('pera asdas', '123', 'sdfasd', '3434333', 1, 5);
insert into post (description, picture_path, video_path, date_time, user_id, views) values (' asdas', '123', 'sdfasd', '3434', 2, 5);
insert into post (description, picture_path, video_path, date_time, user_id, views) values ('pera asdasdaadas', '123', 'sdfasd', '34333', 3, 3);
insert into post (description, picture_path, video_path, date_time, user_id, views) values ('peraoiuytr', '123', 'sdfasd', '333', 2, 6);
insert into post (description, picture_path, video_path, date_time, user_id, views) values ('peasdasdas', '123', 'sdfasd', '3433', 1, 9);

insert into comment (description, date_time, user_id, post_id) values ('pera asdas', '123', 3, 5);
insert into comment (description, date_time, user_id, post_id) values ('pera asdas', '123', 3, 5);
insert into comment (description, date_time, user_id, post_id) values ('pera asdas', '123', 3, 5);

insert into like_dislike (type, post_id, user_id) values ('LIKE', 5, 3);