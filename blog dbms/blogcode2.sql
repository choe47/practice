-----
sign up(for test)데이터 집어넣기
-----
insert into bloguser(user_password, user_name, user_email, user_signupdate)
			value("melonjuice", "noah", "noah@gmail.com", "2018-03-21 12:32:12")

-----
site에 user_id 입력하기 위한 절차 1
-----
select bloguser.user_id from bloguser, site
where  bloguser.user_id <> site.user_id

-----
site에 user_id 입력
-----
insert into site(user_id)
			value("1")
-----
텍스트 입력하기
-----
insert into blogpost(user_id, post_state, post_txt, post_like, post_date, blog_id)
			value("1", "1", "# blog text for my blog", "0", "2019-02-23 12:32:12", "1")

-----
로그인? 패스워드 가져오기. 자바에서는 이거랑 비교하기
------
select user_password from bloguser where user_email = "input email"
-----
포스트 가져오기
-----
select post_txt, post_like, post_date from blogpost where user_id = "id" and post_state = "1" order by post_date desc
-----


