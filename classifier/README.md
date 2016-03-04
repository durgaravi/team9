This `classifier` distribution is a maven distribution that contains scripts to run Byte Frequency Analysis, Byte Frequency Correlation, Correlation matrix and File Header Trailer Analysis on 15 chosen mimetypes. The code results in generating a fingerprint file and JSON visualization files for each of the 15 mimetypes.

To run the entire setup on your local machine:

### Files present:
1. src/main/java: Contains the Java source programs for File classification 

### Prerequisites:
1. Java, Maven

### How to use:

1. To run Byte Frequency Analysis: `$ FileClassifer.java <path to source folder>`<path to target folder>

<path to source folder> - directory containing polar files
<path to target folder> - directory to move all the files and classify them

