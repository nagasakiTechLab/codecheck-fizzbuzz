"use strict";

const expect = require("chai").expect;
const codecheck = require("codecheck");
const testcases = require("./testcase.json");
const app = codecheck.consoleApp(process.env.APP_COMMAND);

describe("Flexible FizzBuzz Concat", () => {

  it('should output a non-empty string when given correct inputs', () => {
    return app.codecheck(testcases[0].input).then(result => {
      expect(result.code).to.equal(0);
      expect(result.stdout[0]).to.be.ok;
    });
  });

  testcases.map((testcase) => {
    it(`should output '${testcase.output}' when recieving input '${testcase.input.join(" ")}'`, () => {
      return app.codecheck(testcase.input).then(result => {
        expect(result.code).to.equal(0);
        expect(result.stdout.join("")).to.equal(testcase.output);
      });
    });
  });
});
