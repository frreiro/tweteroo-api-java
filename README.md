<div align="center" >
  <img width="150px" src="https://bootcampra.notion.site/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F5e9da2a7-eb35-45d8-bdab-81e5dcf58be8%2Fimage_2022-01-20_171006.png?table=block&id=9dc37f2b-9bc9-4554-aac3-91b783971b53&spaceId=f797e032-5eb2-4c9d-beb7-cd7181e19e47&width=250&userId=&cache=v2" alt="ng-logo" width="400">
  <br>
  <br>
  <h1>Tweteroo</h1>
</div>

## 📝 Description


Tweteroo is a social network application, which is a clone of Twitter. This application is a project to train about Java Spring Boot

## 🚀 Technologies

- [Java](https://www.java.com)
- [SpringBoot](https://spring.io/projects/spring-boot)

## 📦 Installation

Clone the repository.

```bash
# https
$ git clone https://github.com/frreiro/tweteroo-api-java
# ssh
$ git clone git@github.com:frreiro/tweteroo-api-java.git
```



## 📌 Features

- [x] User signup
- [x] User create tweet
- [x] Read all tweets with pagination
- [x] Read a single user tweets

## 🔀 Routes

- **POST** `/signup` - Create a new User
  - headers: default
  - body:
	```json
	{
		"username": "yourusername",
		"avatar": "youravatarurl",
	}
	```
  - response: `OK` 

- **POST** `/tweets` - Post a user tweet 
  - headers: default
  - body: 
  ```json
	{
		"username": "yourusername",
		"tweet": "lorem ipsum dolor sit amet",
	}
	```
  - response: `OK` 
- **GET** `/tweets` - Get tweet from all users with pagination, the size is always 5 tweets

  | Query Params |   type   |         Description          |
  | :----------: | :------: | :--------------------------: |
  |     none     |   none   |     first page, page = 0     |
  |    `page`    | `number` | page number, starting with 0 |

	
    - headers: default 
    - body: none
    - response:
    ```json
	{
		"content": [
			{
			"username": "yourusername",
			"avatar": "useravatarurl",
			"tweet": "lorem ipsum dolor sit amet",
			}	
		],
		"pageable": {
		"sort": {
			"empty": false,
			"sorted": true,
			"unsorted": false
			},
		"offset": 0,
		"pageNumber": 0,
		"pageSize": 5,
		"paged": true,
		"unpaged": false
		},
		"totalPages": 0,
		"totalElements": 0,
		"last": true,
		"size": 5,
		"number": 0,
		"sort": {
			"empty": false,
			"sorted": true,
			"unsorted": false
			},
		"numberOfElements": 0,
		"first": true,
		"empty": true
	}
	
	``` 
- **GET** `/tweets/{USERNAME}` - Get user tweets
    - headers: default 
    - body: none
    - response:
    ```json
	[
		{
		"username": "userusername",
		"avatar": "useravatarurl",
		"tweet": "lorem ipsum dolor sit amet",
		}	
	]
	``` 
- **GET** `/health` - Get API health
    - headers: default
    - body: none
    - response: `OK`


### Query details




## 💽 Database

 ___ not implemented yet ___

