/**
 * Created with Web-tekniikat.
 * User: joseu
 * Date: 2015-11-09
 * Time: 07:26 AM
 */
describe("notes module", function () {
    beforeEach(function () {
        notes.clear();
        notes.add("first note");
        notes.add("second note");
        notes.add("third note");
        notes.add("fourth note");
        notes.add("fifth note");
    });
    describe("adding a note", function () {
        it("should be able to add a new note", function () {
            expect(notes.add("sixth note")).toBe(true);
            expect(notes.count()).toBe(6);
        });
        it("should ignore blank notes", function () {
            expect(notes.add("")).toBe(false);
            expect(notes.count()).toBe(5);
        });
        it("should ignore notes containing only whitespace", function () {
            expect(notes.add("   ")).toBe(false);
            expect(notes.count()).toBe(5);
        });
        it("should require a string parameter", function () {
            expect(notes.add()).toBe(false);
            expect(notes.count()).toBe(5);
        });
    });
    describe("deleting a note", function () {
        it("should be able to delete the first index", function () {
            expect(notes.remove(0)).toBe(true);
            expect(notes.count()).toBe(4);
        });
        it("should be able to delete the last index", function () {
            expect(notes.remove(notes.count() - 1)).toBe(true);
            expect(notes.count()).toBe(4);
        });
        it("should return false if index is out of range", function () {
            expect(notes.remove(notes.length + 1)).toBe(false);
            expect(notes.count()).toBe(5);
        });
        it("should return false if the parameter is missing", function () {
            expect(notes.remove()).toBe(false);
            expect(notes.count()).toBe(5);
        });
    });
    describe("finding a note", function () {
        it("should be able to find notes", function () {
            var found = notes.find("note");
            expect(found).not.toBe(false);
            expect(found.length).toBe(5);
        });
        it("should be able to find notes with a case insensitive search string", function () {
            var found = notes.find("Note");
            expect(found).not.toBe(false);
            expect(found.length).toBe(5);
        });
        it("should be able to find notes with a partial search string match", function () {
            var found = notes.find("th");
            expect(found).not.toBe(false);
            expect(found.length).toBe(3);
        });
        it("should be able to find a specific note", function () {
            var found = notes.find("four");
            expect(found).not.toBe(false);
            expect(found.length).toBe(1);
        });
        it("should not be able to find nonexisting notes", function () {
            var found = notes.find("six");
            expect(found).toBe(false);
        });
        it("should not be able to find notes with a blank search string", function () {
            var found = notes.find("");
            expect(found).toBe(false);
        });
        it("should not be able to find notes without a search string", function () {
            var found = notes.find();
            expect(found).toBe(false);
        });
    });
    describe("listing contents", function () {
        it("should be able to list all notes", function () {
            expect(notes.list()).toBeTruthy();
            expect(notes.list().length).toBe(5);
        });
    });
});