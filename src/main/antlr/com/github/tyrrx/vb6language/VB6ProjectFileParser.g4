// https://datatracker.ietf.org/doc/html/rfc5234

grammar VB6ProjectFileParser;


// 2.1.1.1 Common ABNF Rules (https://docs.microsoft.com/en-us/openspecs/office_file_formats/ms-ovba/8c6bc3d1-5316-4452-9f67-f626b03cd15d)
CR     : [\u000D];                                     //  CR     = %x0D
DIGIT  : [\u0030-\u0039];                              //  DIGIT  = %x30-39
DQUOTE : [\u0022];                                     //  DQUOTE = %x22
HEXDIG : DIGIT | 'A' | 'B' | 'C' | 'D' | 'E' | 'F';    //  HEXDIG = DIGIT / "A" / "B" / "C" / "D" / "E" / "F"
HTAB   : [\u0009];                                     //  HTAB   = %x09
LF     : [\u000A];                                     //  LF     = %x0A
SP     : [\u0020];                                     //  SP     = %x20
VCHAR  : [\u0021-\u007E];                              //  VCHAR  = %x21-7E
WSP    : SP | HTAB;                                    //  WSP    = SP / HTAB

// 2.1.1.2 ANYCHAR (https://docs.microsoft.com/en-us/openspecs/office_file_formats/ms-ovba/0f44ba8f-f56a-41b7-80b9-78f0afcf2b74)
ANYCHAR : [\u0001-\u0009] | [\u000B] | [\u000C] | [\u000E-\u00FF];  //  ANYCHAR = %x01-09 / %x0B / %x0C / %x0E-FF

// 2.1.1.3 EQ (https://docs.microsoft.com/en-us/openspecs/office_file_formats/ms-ovba/daa33f4f-6f55-485e-8229-ab52de20c551)
EQ      : WSP* '=' WSP*; //  EQ = *WSP "=" *WSP

// 2.1.1.4 FLOAT (https://docs.microsoft.com/en-us/openspecs/office_file_formats/ms-ovba/5c8e5b20-1c86-4b5f-9d36-e749e832e969)
FLOAT   : SIGN? ((DIGIT+ '.' DIGIT+ EXP?) | ('.' DIGIT+ EXP?) | (DIGIT+ '.'? EXP? )); /* FLOAT = [SIGN] ( ( 1*DIGIT "."  1*DIGIT [EXP] ) /
                                                                                                    ( "."  1*DIGIT [EXP] ) /
                                                                                                    ( 1*DIGIT ["."] [EXP] ) ) */
EXP     : ('e' | 'E') SIGN?  DIGIT+;    //  EXP   = "e"  [SIGN]  1*DIGIT
SIGN    : '+'  | '-';           //  SIGN  = "+"  / "-"

// 2.1.1.5 GUID (https://docs.microsoft.com/en-us/openspecs/office_file_formats/ms-ovba/dcef074c-31e8-4261-a49a-15e5513d0b27)
// GUID = "{" 8HEXDIG "-" 4HEXDIG "-" 4HEXDIG "-" 4HEXDIG "-" 12HEXDIG "}"
GUID :  '{' HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG
        '-' HEXDIG HEXDIG HEXDIG HEXDIG
        '-' HEXDIG HEXDIG HEXDIG HEXDIG
        '-' HEXDIG HEXDIG HEXDIG HEXDIG
        '-' HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG '}';

HEXINT32 : ('&

H'| '&h') HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG HEXDIG;

