![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
<br/>
![Static Badge](https://img.shields.io/badge/17-JAVA_version-orange)
![Static Badge](https://img.shields.io/badge/3.3.4-Spring_Boot_version-gree)

# 🚙 Project 3 - Develop the back-end using Spring Boot

...

## 📖 Table of Contents

- [Project](#-project)
    - [Prerequisites](#prerequisites)
    - [Starting the project](#starting-the-project)
    - [Build the project](#build-the-project)
- [Documentation](#-documentation)
    - [Architecture](#architecture)
    - [Mock Data](#models)
    - [Models](#mock-data)
    - [Library](#library)

## 📁 Project

### Prerequisites

- Fork or Clone this project

- Install your node_modules before starting with `npm install`

### Starting the project

1. Run `ng serve` for start the development server.
2. Navigate to `http://localhost:4200/`.

> [!NOTE]
> The application will automatically reload if you change any of the source files.

### Build the project

Run `ng build` to build the project.

> [!NOTE]
> The build artifacts will be stored in the `dist/` directory.

## 📄 Documentation

### Architecture

The predefined architecture includes (in addition to the default angular architecture) the following:

- `core` folder: contains the business logic (`services` and `models` folders)
- `pages` folder: contains components used for routing
- `shared` folder: contains reusable components

### Mock Data

- `assets/mock/olympic.json` folder: contains the data used in app

### Models

```typescript
//Olympic.ts
class Olympic {
  id!: number;
  country!: string;
  participations!: Participation[];
}
```

```typescript
//Participation.ts
class Participation {
  id!: number;
  year!: number;
  city!: string;
  medalsCount!: number;
  athleteCount!: number;
}
```

### Library

- `ngx-charts` library: for graphics
