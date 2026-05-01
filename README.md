#  Flatmate Finder - Java Lab Project

 IMPORTANT NOTICE

This project is created by Jigesha Kapoor for academic purposes.

- Do NOT copy this code for submissions  
- Do NOT reuse without permission  
- Proper credit is required if referenced  

Unauthorized usage may lead to academic violation.

---

##  Project Description
Flatmate Finder is a backend system built using Java and Spring Boot.

It allows users to:
- Register & login  
- Set preferences  
- Find compatible flatmates  
- Swipe and match users  
- Chat with matches  
- Browse and book flats  

---

## 🛠️ Tech Stack
- Java  
- Spring Boot  
- MySQL  
- REST API  
- JPA / Hibernate  

---

## API Endpoints

| Endpoint | Method | Description |
|---------|--------|------------|
| /api/auth/register | POST | Register new user |
| /api/auth/login | POST | User login |
| /api/users/{id} | GET | Get user by ID |
| /api/users/{id} | PUT | Update user profile |
| /api/users/{id}/preferences | GET | Get user preferences |
| /api/users/{id}/preferences | PUT | Update preferences |
| /api/matches/potential/{userId} | GET | Get potential matches |
| /api/matches/swipe/{userId} | POST | Swipe on user |
| /api/matches/confirmed/{userId} | GET | Get confirmed matches |
| /api/chat/{matchId}/messages | GET | Get chat messages |
| /api/chat/{matchId}/messages | POST | Send message |
| /api/flats | GET | Get all flats |
| /api/flats | POST | Create flat |
| /api/flats/{id}/book | POST | Book a flat |
| /api/flats/search | GET | Search flats |

---

## Sample Requests & Responses

###  Register Response
POST /api/auth/register

```json
{
  "success": true,
  "message": "Registration successful",
  "token": "token_1_1699000000000",
  "user": {
    "id": 1,
    "email": "john@example.com",
    "fullName": "John Doe",
    "userType": "SEEKER"
  }
}

Login User

POST /api/auth/login

{
  "email": "john@example.com",
  "password": "password123"
}

Update Preferences

PUT /api/users/1/preferences

{
  "smoking": false,
  "drinking": "OCCASIONAL",
  "foodType": "VEG",
  "sleepSchedule": "NIGHT_OWL",
  "cleanlinessLevel": "HIGH",
  "minBudget": 8000,
  "maxBudget": 15000,
  "guestsAllowed": "OCCASIONAL",
  "workType": "WORKING"
}
  Swipe Action

POST /api/matches/swipe/1

{
  "targetUserId": 2,
  "action": "LIKE"
}
  Response (Match Found)
{
  "success": true,
  "isMatch": true,
  "matchPercentage": 87.5,
  "matchId": 1,
  "message": "It's a match! You can now chat."
}
