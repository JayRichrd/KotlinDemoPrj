package com.tencent.cain

class ImportantIssuesPredicate(val project: String) : (Issue) -> Boolean {
    override fun invoke(issue: Issue): Boolean {
        return issue.project == project && issue.isImportant()
    }

    private fun Issue.isImportant(): Boolean {
        return type.toLowerCase() == "bug" && (priority.toLowerCase() == "major" || priority.toLowerCase() == "critical")
    }

}