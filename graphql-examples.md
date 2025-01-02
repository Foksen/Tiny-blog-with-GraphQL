# Operation examples

## 1. Queries

### 1.1. Get user by ID

```graphql
query {
    user(id: 1) {
        id
        nickname
        email
        posts {
            id
            createdAt
            text
        }
    }
}
```

### 1.2. Get all users

```graphql
query {
    users {
        id
        nickname
        email
        posts {
            id
            createdAt
            text
        }
    }
}
```

### 1.3. Get post by ID

```graphql
query {
    post(id: 1) {
        id
        createdAt
        author {
            id
            nickname
            email
        }
        text
    }
}
```

### 1.4. Get all posts

```graphql
query {
    posts {
        id
        createdAt
        author {
            id
            nickname
            email
        }
        text
    }
}
```

### 1.5. Get all posts by author by his ID

```graphql
query {
    postsByUser(userId: 1) {
        id
        createdAt
        text
    }
}
```

## 2. Mutations

### 2.1. Create user

```graphql
mutation {
    createUser(input: {username: "Foksen", password: "myPass", email: "izholobov2004@gmail.com"}) {
        id
        username
        email
    }
}
```

### 2.2. Create post

```graphql
mutation {
    createPost(input: {userId: 1, text: "Some text"}) {
        id
        createdAt
        author {
            id
            username
            email
        }
        text
    }
}
```