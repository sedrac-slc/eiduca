package app.com.eiduca.core.constant

 class MessageDoc{
     companion object {
         const val STATUS_UPDATE: String = "202"
         const val STATUS_CREATED: String = "201"
         const val STATUS_DELETED: String = "204"
         const val STATUS_NOT_FOUND: String = "404"
         const val STATUS_FAILED: String = "400"
         const val STATUS_PERMISSION_DENIED: String = "401"

         const val UPDATE: String = "Item updated successfully"
         const val CREATED: String = "Item created successfully"
         const val DELETED: String = "Item successfully deleted"
         const val NOT_FOUND: String = "If the item is not found, a response with status 404 will be returned"
         const val FAILED: String = "Invalid request: Failed to validate the data provided or incorrect format"
         const val PERMISSION_DENIED: String = "Permission denied"

         const val SUMMARY_FIND_ALL: String = "Get paginated list of items"
         const val DESCRIPTION_FIND_ALL: String = "This endpoint allows retrieving a list of items with pagination support"

         const val SUMMARY_FIND_BY_ID: String = "Get details of a specific item"
         const val DESCRIPTION_FIND_BY_ID: String = "This endpoint allows retrieving the details of a specific item based on its unique identifier. You must provide the item ID as an input parameter"

         const val SUMMARY_SAVE: String = "Create a new item"
         const val DESCRIPTION_SAVE: String = "Endpoint for creating a new item. You must provide the item details in the request body. The response will include the created item with its unique identifier"

         const val SUMMARY_UPDATE: String = "Update an existing item"
         const val DESCRIPTION_UPDATE: String = "Endpoint for updating an existing item. You must provide the item ID and updated details in the request body. The response will include the updated item"

         const val SUMMARY_DELETE: String = "Delete an item"
         const val DESCRIPTION_DELETE: String = "Endpoint for deleting an existing item. You must provide the ID of the item you want to delete. The response will indicate the success or failure of the operation"
     }
}