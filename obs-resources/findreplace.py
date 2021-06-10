import argparse

# Initialize the arguments, all are required
def init_args():
    parser = argparse.ArgumentParser(
        description="Find and replace contents in a file",
        usage=r'python find-replace.py --infile "C:\Users\My Name\Downloads\some-data.json" --outfile out.json --find "My Name" --replace anonymous'
    )
    parser.add_argument("--infile", help="Input file path", required=True)
    parser.add_argument("--outfile", help="Output file path", required=True)
    parser.add_argument("--find", help="Text to find", required=True)
    parser.add_argument("--replace", help="Text to be replaced with", required=True)

    return parser

def doReplace(inFile, outFile, findText, replaceWith):
    print("Will replace occurences of: " + findText + "\nin file: " + inFile + "\nwith: " + replaceWith + "\nand write to: " + outFile)
    # Open the input file and output file
    with open(inFile, 'r') as target, open(outFile, 'w') as result:

        # Create new data, replacing text with desired
        newData = target.read().replace(findText, replaceWith)

        # Write new data to desired file
        result.write(newData)

def main():
    # Init and parse args
    parser = init_args()
    args = parser.parse_args()

    doReplace(args.infile, args.outfile, args.find, args.replace)

if __name__ == "__main__":
    main()