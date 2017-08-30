# !bin/sh

FILE_NAME=PalindromeNumber.c
TARGET_NAME=${FILE_NAME%.*}
SOURCE_DIR=./code
TARGET_DIR=./bin
cd $SOURCE_DIR
TARGET=."$TARGET_DIR"/"$TARGET_NAME"
if [ "${FILE_NAME##*.}" == "c" ]; then
	gcc $FILE_NAME -o $TARGET
	cd .$TARGET_DIR
	chmod +x $TARGET_NAME
	./$TARGET_NAME
fi
if [ "${FILE_NAME##*.}" == "java" ]; then
	javac $FILE_NAME
	mv *.class .$TARGET_DIR
	cd .$TARGET_DIR
	java $TARGET_NAME
fi