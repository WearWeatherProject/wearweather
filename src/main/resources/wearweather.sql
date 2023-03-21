--Root 계정에서 실행.
create database wearweather default character set utf8;
create user 'shopuser'@'localhost' identified by 'shopuser';
grant all privileges on wearweather.* to 'shopuser'@'localhost';
create user 'shopuser'@'%' identified by 'shopuser';
grant all privileges on wearweather.* to 'shopuser'@'%';

--루트계정 비밀번호를 1234로 변경한다.
ALTER user 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '1234';