import argparse
import findreplace
import os
from pathlib import PurePath

# Initialize the arguments, all are required
def init_args():
  parser = argparse.ArgumentParser(
    description="Exports the present scene collection file, de-anonymizing it to that paths are relative to this directory",
    usage=r'python export.py'
  )
  parser.add_argument("outdir", help="Output file path")

  return parser

def main():
  # Init and parse args
  parser = init_args()
  args = parser.parse_args()

  # Get the current directory path
  dirPath = os.path.dirname(os.path.realpath(__file__))
  inFile = os.path.join(dirPath, "AnonymizedSceneCollection.json")
  replace = PurePath(dirPath).as_posix()
  outFile = os.path.join(args.outdir, "TestSceneCollection.json")
  findreplace.doReplace(inFile, outFile, "REPLACE_ME", replace)

if __name__ == "__main__":
  main()