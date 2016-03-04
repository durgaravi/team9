This `detection` distribution is a maven distribution that contains scripts to run Byte Frequency Analysis, Byte Frequency Correlation, Correlation matrix and File Header Trailer Analysis on 15 chosen mimetypes. The code results in generating a fingerprint file and JSON visualization files for each of the 15 mimetypes.

To run the entire setup on your local machine:

### Files present:
1. src/main/java: Contains the Java source programs for BFA, BFC and FHT
2. src/main/resources/fingerprint_files: Contains fingerprint files that are text files having no. of files trained on in the first line and tab separated pair of <byte frequency,byte correlation score> for 256 bytes in the next line.
3. src/main/resources/visualization_files: Contains visualization .html files along with result JSON files for each mimetype and supporting CSS and JavaScript libraries.

### Prerequisites:
1. Java, Maven

### How to use:

We consider the data to be in a root folder which has the following directory structure:

root

  |_ audio

    |_ mpeg

      |_data
      
      |_testfiles
      
      |_audio-mpeg.txt (this is an initial fingerprint that has all values initialised to 0)

and similarly for other file types

1. To run Byte Frequency Analysis: `$ ByteFrequencyAnalysis.java <path to root folder>`
2. To run Byte Frequency Correlation: `$ ByteFrequencyCorrelation.java <path to root folder>`
3. To run File Header Trailer: `$ FHTAnalysis.java <path to root folder>`

