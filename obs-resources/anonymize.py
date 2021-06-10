import argparse
import findreplace
import os
from pathlib import PurePath

# Initialize the arguments, all are required
def init_args():
  parser = argparse.ArgumentParser(
    description="Imports a scene collection file, doing a find and replace for this working directory and anonymizing it",
    usage=r'python import.py "C:\Users\My Name\Downloads\scenecollection.json"'
  )
  parser.add_argument("infile", help="Input file path")

  return parser

def main():
  # Init and parse args
  parser = init_args()
  args = parser.parse_args()

  # Get the current directory path
  dirPath = os.path.dirname(os.path.realpath(__file__))
  outfile = os.path.join(dirPath, "AnonymizedSceneCollection.json")
  findText = PurePath(dirPath).as_posix()
  findreplace.doReplace(args.infile, outfile, findText, "REPLACE_ME")

if __name__ == "__main__":
  main()