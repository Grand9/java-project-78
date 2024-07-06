
---

# Data Validator Library

This library is designed to validate various objects against established restrictions using the `isValid()` method, which accepts arguments of type `int`, `String`, or `Map`.

**Validator** creates schemas using the following methods, each containing restrictions for the respective object types:

- **string()**:
  - Creates a schema for `String` validation and applies restrictions using the following methods:
    - `required()` - restricts `null` and empty strings.
    - `minLength()` - requires the string to be of a minimum length specified by the argument.
    - `contains()` - requires the string to contain the specified substring.

**Example:**

```java
Validator v = new Validator();
StringSchema schema = v.string();

// Before calling required(), null and empty strings are considered valid
schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(""); // false
schema.isValid(5); // false
schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
// Now false, as contains("whatthe") check is added
```

- **number()**:
  - Creates a schema for `int` validation and applies restrictions using the following methods:
    - `required()` - restricts `null` values.
    - `positive()` - restricts numbers less than or equal to zero.
    - `range()` - requires the number to fall within a specified range.

**Example:**

```java
Validator v = new Validator();
NumberSchema schema = v.number();

// Before calling required(), null is considered valid
schema.isValid(null); // true
schema.positive().isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid("5"); // false
schema.isValid(10); // true

// Since positive() was called earlier
schema.isValid(-10); // false
// Zero is not a positive number
schema.isValid(0); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```

- **map()**:
  - Creates a schema for `Map` validation and applies restrictions using the following methods:
    - `required()` - restricts `null` maps.
    - `sizeof()` - restricts maps to a specific size defined by the argument.
    - `shape()` - validates a map against specified schemas for each key-value pair.

**Example:**

```java
Validator v = new Validator();
MapSchema schema = v.map();

Map<String, BaseSchema<?>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));

schema.shape(schemas);

Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
System.out.println(schema.isValid(human1)); // true

Map<String, String> human2 = new HashMap<>();
human2.put("firstName", "John");
human2.put("lastName", null);
System.out.println(schema.isValid(human2)); // false

Map<String, String> human3 = new HashMap<>();
human3.put("firstName", "Anna");
human3.put("lastName", "B");
System.out.println(schema.isValid(human3)); // false
```

### Hexlet Tests and Linter Status:
[![Actions Status](https://github.com/Grand9/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Grand9/java-project-78/actions)
[![Actions Status](https://github.com/Grand9/java-project-78/actions/workflows/ci.yml/badge.svg)](https://github.com/Grnd9/java-project-78/actions)
### Code Climate Badges
[![Maintainability](https://api.codeclimate.com/v1/badges/23b8ae5fdd3689fd8835/maintainability)](https://codeclimate.com/github/Grand9/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/23b8ae5fdd3689fd8835/test_coverage)](https://codeclimate.com/github/Grand9/java-project-78/test_coverage)
### asciinema
[![asciicast](text.svg)](text)

---
