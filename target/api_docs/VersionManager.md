## ??
```json
{
  "loadManager": {
    "AGENT_JAR": {
      "fs": {
        "BA_EXISTS": 1,
        "BA_REGULAR": 1,
        "BA_DIRECTORY": 1,
        "BA_HIDDEN": 1,
        "ACCESS_READ": 1,
        "ACCESS_WRITE": 1,
        "ACCESS_EXECUTE": 1,
        "SPACE_TOTAL": 1,
        "SPACE_FREE": 1,
        "SPACE_USABLE": 1,
        "useCanonCaches": false,
        "useCanonPrefixCache": false
      },
      "path": "@string",
      "status": {},
      "prefixLength": 1,
      "separatorChar": "a",
      "separator": "@string",
      "pathSeparatorChar": "a",
      "pathSeparator": "@string",
      "UNSAFE": {
        "theUnsafe": {},
        "INVALID_FIELD_OFFSET": 1,
        "ARRAY_BOOLEAN_BASE_OFFSET": 1,
        "ARRAY_BYTE_BASE_OFFSET": 1,
        "ARRAY_SHORT_BASE_OFFSET": 1,
        "ARRAY_CHAR_BASE_OFFSET": 1,
        "ARRAY_INT_BASE_OFFSET": 1,
        "ARRAY_LONG_BASE_OFFSET": 1,
        "ARRAY_FLOAT_BASE_OFFSET": 1,
        "ARRAY_DOUBLE_BASE_OFFSET": 1,
        "ARRAY_OBJECT_BASE_OFFSET": 1,
        "ARRAY_BOOLEAN_INDEX_SCALE": 1,
        "ARRAY_BYTE_INDEX_SCALE": 1,
        "ARRAY_SHORT_INDEX_SCALE": 1,
        "ARRAY_CHAR_INDEX_SCALE": 1,
        "ARRAY_INT_INDEX_SCALE": 1,
        "ARRAY_LONG_INDEX_SCALE": 1,
        "ARRAY_FLOAT_INDEX_SCALE": 1,
        "ARRAY_DOUBLE_INDEX_SCALE": 1,
        "ARRAY_OBJECT_INDEX_SCALE": 1,
        "ADDRESS_SIZE": 1
      },
      "PATH_OFFSET": 1,
      "PREFIX_LENGTH_OFFSET": 1
    }
  },
  "totalVersion": {
    "name": "@string",
    "pathDll": "@string",
    "pathJar": "@string",
    "minecraftJarfileName": "@string",
    "args": {
      "DEFAULT_CAPACITY": 1,
      "EMPTY_ELEMENTDATA": [
        {}
      ],
      "DEFAULTCAPACITY_EMPTY_ELEMENTDATA": [
        {}
      ],
      "elementData": [
        {}
      ],
      "size": 1,
      "modCount": 1
    }
  },
  "isLoaded": false
}
```
## ????
??|??|??|????|??/??
---|---|---|---|---
**loadManager**|LoadManager|N|N/A|Stores the Loader Manager object.
?**AGENT_JAR**|File|N|N/A|This field contains the path to the jar agent required by ByteBuddy.
??**fs**|FileSystem|N|N/A|
???BA_EXISTS|int|N|N/A|
???BA_REGULAR|int|N|N/A|
???BA_DIRECTORY|int|N|N/A|
???BA_HIDDEN|int|N|N/A|
???ACCESS_READ|int|N|N/A|
???ACCESS_WRITE|int|N|N/A|
???ACCESS_EXECUTE|int|N|N/A|
???SPACE_TOTAL|int|N|N/A|
???SPACE_FREE|int|N|N/A|
???SPACE_USABLE|int|N|N/A|
???useCanonCaches|boolean|N|N/A|
???useCanonPrefixCache|boolean|N|N/A|
??path|String|N|N/A|
??status|PathStatus|N|N/A|
??prefixLength|int|N|N/A|
??separatorChar|char|N|N/A|
??separator|String|N|N/A|
??pathSeparatorChar|char|N|N/A|
??pathSeparator|String|N|N/A|
??**UNSAFE**|Unsafe|N|N/A|
???theUnsafe|Unsafe|N|N/A|
???INVALID_FIELD_OFFSET|int|N|N/A|
???ARRAY_BOOLEAN_BASE_OFFSET|int|N|N/A|
???ARRAY_BYTE_BASE_OFFSET|int|N|N/A|
???ARRAY_SHORT_BASE_OFFSET|int|N|N/A|
???ARRAY_CHAR_BASE_OFFSET|int|N|N/A|
???ARRAY_INT_BASE_OFFSET|int|N|N/A|
???ARRAY_LONG_BASE_OFFSET|int|N|N/A|
???ARRAY_FLOAT_BASE_OFFSET|int|N|N/A|
???ARRAY_DOUBLE_BASE_OFFSET|int|N|N/A|
???ARRAY_OBJECT_BASE_OFFSET|int|N|N/A|
???ARRAY_BOOLEAN_INDEX_SCALE|int|N|N/A|
???ARRAY_BYTE_INDEX_SCALE|int|N|N/A|
???ARRAY_SHORT_INDEX_SCALE|int|N|N/A|
???ARRAY_CHAR_INDEX_SCALE|int|N|N/A|
???ARRAY_INT_INDEX_SCALE|int|N|N/A|
???ARRAY_LONG_INDEX_SCALE|int|N|N/A|
???ARRAY_FLOAT_INDEX_SCALE|int|N|N/A|
???ARRAY_DOUBLE_INDEX_SCALE|int|N|N/A|
???ARRAY_OBJECT_INDEX_SCALE|int|N|N/A|
???ADDRESS_SIZE|int|N|N/A|
??PATH_OFFSET|long|N|N/A|
??PREFIX_LENGTH_OFFSET|long|N|N/A|
??filePath|Path|N|N/A|
**totalVersion**|Version|N|N/A|Stores the current version.
?name|String|N|N/A|Contains the name of the version.
?pathDll|String|N|N/A|Contains the path to the folder with natives.
?pathJar|String|N|N/A|Contains the path to the folder with jar files.
?minecraftJarfileName|String|N|N/A|Contains the name of the minecraft jar file.
?**args**|ArrayList<String>|N|N/A|
??DEFAULT_CAPACITY|int|N|N/A|
??EMPTY_ELEMENTDATA|Object[]|N|N/A|
??DEFAULTCAPACITY_EMPTY_ELEMENTDATA|Object[]|N|N/A|
??elementData|Object[]|N|N/A|
??size|int|N|N/A|
??modCount|int|N|N/A|
isLoaded|boolean|N|N/A|The status of the loaded version or not.