## Training Center Management API

## Prerequisites

1. Database: Set up a database (MySQL) and configure the database connection details in application.properties

## Access API Endpoints

Base URL: http://localhost:8080/api/training-centers

1. `Create Training Center`

**URL: POST /api/training-centers**
**Request Body: JSON payload containing details of the new training center.**
**Parameters:** centerName, centerCode,address: Address details (street, city, state, pincode)
,studentCapacity,coursesOffered,contactEmail,contactPhone
**Response: JSON object representing the created training center.**
**Sample Data**

``` javascript
 {
  "centerName": "FutureSkills Institute",
  "centerCode": "FSI987654321",
  "address": {
    "street": "789 Innovation Boulevard",
    "city": "Techton",
    "state": "Innovia",
    "pincode": "67890"
  },
  "studentCapacity": 75,
  "coursesOffered": ["Artificial Intelligence", "Machine Learning", "Blockchain"],
  "contactEmail": "info@futureskills.com",
  "contactPhone": "9876543210" 
  }
  ```

2. `Get All Training Centers`

**URL:** GET /api/training-centers
**Parameters:**

1. city: Filter training centers by city (optional).
2. state: Filter training centers by state (optional).

**Response: JSON array containing a list of training center objects.**




