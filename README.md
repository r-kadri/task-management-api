# Task Management API
Small API to learn the Spring Boot framework.

## Exercice

You are required to build a RESTful API to manage a list of tasks. Each task should have a unique identifier, a label, a description, and a status (in progress, completed, etc.).

## Expected Features

1. **Adding a Task:**
   - **Endpoint:** `/tasks/add`
   - **Method:** POST
   - **Parameters:**
      - Label (label)
      - Description (description)
   - **Response:** The added task with its unique identifier.

2. **Fetching All Tasks:**
   - **Endpoint:** `/tasks`
   - **Method:** GET
   - **Response:** A list of all tasks.

3. **Fetching a Task by its Identifier:**
   - **Endpoint:** `/tasks/{id}`
   - **Method:** GET
   - **Parameter:** Task identifier (id)
   - **Response:** The corresponding task.

4. **Updating the Status of a Task:**
   - **Endpoint:** `/tasks/{id}/updateStatus`
   - **Method:** PUT
   - **Parameter:** Task identifier (id)
   - **Request Body:** New status
   - **Response:** The updated task.

5. **Deleting a Task:**
   - **Endpoint:** `/tasks/{id}/delete`
   - **Method:** DELETE
   - **Parameter:** Task identifier (id)
   - **Response:** Deletion confirmation.
