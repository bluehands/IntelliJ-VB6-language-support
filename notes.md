# Enum Statement
- Shadowing
  - Enum type > Enum member
- Ambiguous name with
  - Enum member with variables properties or functions
  
## Type Statement
- Ambiguous name with
  - Module
  - Project
  - Object Library
  - Enum type
- Not Ambiguous name with 
  - Variable
  - Enum member
  - Function / Sub / Prop
  - Event
- Visibility
  - Public by default 
  - Cannot define a Public user defined type within a private object module (cls)
- Reference
  - Not Call or Variable
  - As Type Clause


# Definitions
- Enum as Type 
- Enum member as constant E.X
- Event as trigger able
- Type as Type
- Type member as (Member access)
- Module var as variable
- Module const as constant / variable
- Block var as variable
- Block let as variable (Option not Explicit)
- Function as callable
- Property as callable
- Sub as callable
- Declare Sub / Fun as callable
- Line labels as line label
- File number -> property getter

Type myType
  X as String


Enum myEnum
  x = 1

MsgBox 